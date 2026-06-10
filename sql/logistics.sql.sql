CREATE TABLE Partners (
    PartnerID INT PRIMARY KEY,
    PartnerName VARCHAR(100)
);

CREATE TABLE Shipments (
    ShipmentID INT PRIMARY KEY,
    PartnerID INT,
    DestinationCity VARCHAR(50),
    OrderDate DATE,
    PromisedDate DATE,
    ActualDeliveryDate DATE,
    Status VARCHAR(20),
    FOREIGN KEY (PartnerID) REFERENCES Partners(PartnerID)
);

CREATE TABLE DeliveryLogs (
    LogID INT PRIMARY KEY,
    ShipmentID INT,
    StatusUpdate VARCHAR(100),
    UpdateTime DATETIME,
    FOREIGN KEY (ShipmentID) REFERENCES Shipments(ShipmentID)
);
-- INSERT DATA

INSERT INTO Partners VALUES
(1, 'BlueDart'),
(2, 'Delhivery'),
(3, 'Ekart');

INSERT INTO Shipments VALUES
(101, 1, 'Chennai', '2026-03-01', '2026-03-05', '2026-03-06', 'Delivered'),
(102, 2, 'Bangalore', '2026-03-02', '2026-03-06', '2026-03-05', 'Delivered'),
(103, 3, 'Hyderabad', '2026-03-03', '2026-03-07', '2026-03-10', 'Delivered'),
(104, 1, 'Chennai', '2026-03-04', '2026-03-08', NULL, 'In Transit'),
(105, 2, 'Mumbai', '2026-03-05', '2026-03-09', '2026-03-15', 'Returned'),
(106, 3, 'Chennai', '2026-03-06', '2026-03-10', '2026-03-09', 'Delivered');

INSERT INTO DeliveryLogs VALUES
(1, 101, 'Picked', '2026-03-01 10:00:00'),
(2, 101, 'Delivered', '2026-03-06 14:00:00'),
(3, 103, 'Delayed', '2026-03-08 12:00:00'),
(4, 105, 'Returned', '2026-03-15 16:00:00');


SELECT ShipmentID, DestinationCity, PromisedDate, ActualDeliveryDate
FROM Shipments
WHERE ActualDeliveryDate > PromisedDate;


SELECT p.PartnerName,
       COUNT(*) AS DeliveredShipments
FROM Shipments s
JOIN Partners p
ON s.PartnerID = p.PartnerID
WHERE s.Status = 'Delivered'
GROUP BY p.PartnerName;


SELECT p.PartnerName,
       COUNT(*) AS Total_Shipments,
       ROUND(SUM(CASE WHEN s.Status = 'Delivered' THEN 1 ELSE 0 END) * 100 / COUNT(*), 2) AS Success_Rate
FROM Shipments s
JOIN Partners p ON s.PartnerID = p.PartnerID
GROUP BY p.PartnerName
ORDER BY Success_Rate DESC;

SELECT p.PartnerName,
       ROUND(SUM(CASE WHEN s.Status = 'Delivered' THEN 1 ELSE 0 END) * 100 / COUNT(*), 2) AS Success_Rate
FROM Shipments s
JOIN Partners p ON s.PartnerID = p.PartnerID
GROUP BY p.PartnerName
ORDER BY Success_Rate ASC
LIMIT 1;


SELECT p.PartnerName,
       AVG(DATEDIFF(s.ActualDeliveryDate, s.PromisedDate)) AS Avg_Delay_Days
FROM Shipments s
JOIN Partners p ON s.PartnerID = p.PartnerID
WHERE s.ActualDeliveryDate > s.PromisedDate
GROUP BY p.PartnerName;


SELECT MONTH(OrderDate) AS Month,
       COUNT(*) AS Orders
FROM Shipments
GROUP BY MONTH(OrderDate);

SELECT ShipmentID,
       DATEDIFF(day, PromisedDate, ActualDeliveryDate) AS Delay_Days
FROM Shipments;

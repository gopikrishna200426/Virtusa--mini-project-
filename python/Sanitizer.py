# Social Media Content Sanitizer
posts = [
    "User123: I hate this app, it's toxic! http://badlink.com",
    "User456: This is a good day!",
    "User789: Visit http://example.com for more info",
    "User123: Such a bad experience!!",
    "User999: Nothing wrong here 😊"
]
banned_words = ["bad", "toxic", "hate"]
total_posts = len(posts)
cleaned_posts = []
blocked_count = 0
user_flags = {}
links = []
for post in posts:
    original_post = post
    user = post.split(":")[0]
    if user not in user_flags:
        user_flags[user] = 0
    for word in banned_words:
        if word in post.lower():
            post = post.replace(word, "***")
            user_flags[user] += 1
            blocked_count += 1
    words = post.split()
    for w in words:
        if w.startswith("http"):
            links.append(w)

    cleaned_posts.append(post)
with open("links_found.txt", "w") as file:
    for link in links:
        file.write(link + "\n")
# Final Output
print("\n--- Cleaned Posts ---")
for p in cleaned_posts:
    print(p)

print("\n--- User Flag Summary ---")
for user, count in user_flags.items():
    print(f"{user}: {count}")

print("\n--- Final Report ---")
print(f"Total Posts Screened: {total_posts}")
print(f"Cleaned Posts: {len(cleaned_posts)}")
print(f"Blocked Words Found: {blocked_count}")
print(f"Total Links Extracted: {len(links)}")

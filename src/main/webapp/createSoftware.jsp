<form action="createSoftware" method="post">
    <input type="text" name="name" placeholder="Software Name" required />
    <textarea name="description" placeholder="Software Description"></textarea>
    <label><input type="checkbox" name="access_levels" value="Read" /> Read</label>
    <label><input type="checkbox" name="access_levels" value="Write" /> Write</label>
    <label><input type="checkbox" name="access_levels" value="Admin" /> Admin</label>
    <button type="submit">Create Software</button>
</form>

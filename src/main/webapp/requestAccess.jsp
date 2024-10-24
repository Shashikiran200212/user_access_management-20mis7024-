<form action="requestAccess" method="post">
    <select name="softwareId">
        <!-- Populate with software from DB -->
    </select>
    <select name="accessType">
        <option value="Read">Read</option>
        <option value="Write">Write</option>
        <option value="Admin">Admin</option>
    </select>
    <textarea name="reason" placeholder="Reason for Access"></textarea>
    <button type="submit">Request Access</button>
</form>

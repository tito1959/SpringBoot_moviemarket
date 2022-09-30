
document.addEventListener("DOMContentLoaded", () => {

    const dropdown = document.getElementById("dropdown-log");
    const login = document.getElementById("login");
    const user = document.getElementById("user");
    const data = localStorage.getItem("loggedUser");

    if (data !== undefined) {
        login.style.display = "none";
        const userInfo = JSON.parse(data);
        user.innerText = userInfo.name;
    } else {
        dropdown.style.display = "none";
    }
});
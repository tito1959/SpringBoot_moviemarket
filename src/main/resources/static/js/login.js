
const postLogin = async (body) => {
    const url = "/api/login";

    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        const user = await response.json();
        localStorage.setItem("loggedUser", JSON.stringify(user));
        console.log("Login Exitoso: ", user);
        window.location.href = "/catalog";
    } else {
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerText = await response.text();
    }

}


document.addEventListener("click", (e) => {

    const button = document.getElementById("button");
    const error = document.getElementById("error");
    const user = document.getElementById("username");
    const password = document.getElementById("password");

    if (e.target === button) {
        e.preventDefault();

        if (user.value === "") {
            error.style.display = "block";
            error.innerText = "Please enter your username";
            return;
        }

        if (password.value === "") {
            error.style.display = "block";
            error.innerText = "Please enter your password";
            return;
        }

        postLogin({
            "username": user.value,
            "password": password.value
        });

    }
});
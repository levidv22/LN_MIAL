function togglePassword() {
    const passwordField = document.getElementById("password");
    const toggleIcon = document.getElementById("toggleIcon");

    if (passwordField.type === "password") {
        passwordField.type = "text";
        toggleIcon.classList.remove("fa-eye");
        toggleIcon.classList.add("fa-eye-slash");
    } else {
        passwordField.type = "password";
        toggleIcon.classList.remove("fa-eye-slash");
        toggleIcon.classList.add("fa-eye");
    }
}

// Mostrar la alerta si el parámetro error está presente en la URL
const urlParams = new URLSearchParams(window.location.search);
if (urlParams.has('error')) {
    const errorAlert = document.getElementById('errorAlert');
    errorAlert.classList.remove('d-none');
}
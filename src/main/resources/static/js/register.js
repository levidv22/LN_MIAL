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

// Función para permitir solo letras y espacios
function allowOnlyText(input) {
    input.value = input.value.replace(/[^A-Za-z\s]/g, '');
}

// Función para permitir solo números
function allowOnlyNumbers(input) {
    input.value = input.value.replace(/[^0-9]/g, '');
}

// Aplicar las restricciones a los campos correspondientes
document.getElementById('username').addEventListener('input', function () {
    allowOnlyText(this);
});

document.getElementById('cellphone').addEventListener('input', function () {
    allowOnlyNumbers(this);
});
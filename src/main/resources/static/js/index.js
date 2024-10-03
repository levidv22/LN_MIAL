function updateCartCount() {
    fetch('/carrito/cantidad')
            .then(response => response.json())
            .then(data => {
                document.getElementById('cart-count').textContent = data;
            })
            .catch(error => console.error('Error al obtener la cantidad del carrito:', error));
}

// Llamar a la función cuando se carga la página
document.addEventListener('DOMContentLoaded', updateCartCount);

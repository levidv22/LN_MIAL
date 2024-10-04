const editProductModal = document.getElementById('editProductModal');

editProductModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget;
    const id = button.getAttribute('data-id');
    const name = button.getAttribute('data-name');
    const description = button.getAttribute('data-description');
    const code = button.getAttribute('data-code');
    const price = button.getAttribute('data-price');
    const image = button.getAttribute('data-image');

    // Rellenar los campos del formulario
    document.getElementById('edit-id').value = id;
    document.getElementById('edit-name').value = name;
    document.getElementById('edit-description').value = description;
    document.getElementById('edit-code').value = code;
    document.getElementById('edit-price').value = price;
    document.getElementById('current-image').src = image;
});

const productForm = document.getElementById('productForm');
const productList = document.getElementById('productList');
const purchasedProductsList = document.getElementById('purchasedProductsList');
const showFormButton = document.getElementById('showFormButton');
const showProductsButton = document.getElementById('showProductsButton');
const showPurchasedProductsButton = document.getElementById('showPurchasedProductsButton');

showFormButton.addEventListener('click', () => {
    productForm.style.display = 'block';
    productList.style.display = 'none';
    purchasedProductsList.style.display = 'none';
});

showProductsButton.addEventListener('click', () => {
    productForm.style.display = 'none';
    productList.style.display = 'block';
    purchasedProductsList.style.display = 'none';
});

showPurchasedProductsButton.addEventListener('click', () => {
    productForm.style.display = 'none';
    productList.style.display = 'none';
    purchasedProductsList.style.display = 'block';
});

// Mostrar el formulario por defecto al cargar la página
window.onload = function () {
    productForm.style.display = 'block';
    productList.style.display = 'none';
    purchasedProductsList.style.display = 'none';
};

let items = new Map();

const cartButton = document.getElementById("cartButton");

document.addEventListener("click", (e) => {

    if (e.target === cartButton) {

        const addToCart = (movie) => {
            let value = 1;
            console.log(items);

            if (items.get(movie) !== undefined) {
                value = items.get(movie) + 1;
                console.log("value: " + value);
            }

            items.set(movie, value);
            updatedCart();
        }
    }
});

const updatedCart = () => {
    const cartBadge = document.getElementById("cart-count");
    let total = 0;

    if (items.size() > 0) {
        total = Array.from(items)
            .map(([key, value]) => { value })
            .reduce((a, b) => a + b);
    }

    console.log("total: " + total);
    cartBadge.innerText = total;
}

updatedCart();
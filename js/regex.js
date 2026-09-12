function validateProductCode(productCode) {
    const pattern = /^#[A-Z]{4}[0-9]{3}$/;

    if (pattern.test(productCode)) {
        return "Product code verified successfully";
    } else {
        return "Product code is not valid";
    }
}

console.log(validateProductCode("#ABCD123"));
console.log(validateProductCode("#abc1234"));

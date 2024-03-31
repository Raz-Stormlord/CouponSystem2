function getCouponName() {
    var couponName = localStorage.getItem('couponName');

    var couponNameDisplay = document.getElementById('couponName');
    if (couponName) {
        couponNameDisplay.textContent = 'Coupon ' + couponName;
    }
} getCouponName()

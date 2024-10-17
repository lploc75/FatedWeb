document.addEventListener('mousemove', function (e) {
    const comet = document.createElement('div');
    comet.classList.add('comet');
    document.body.appendChild(comet);

    const x = e.clientX;
    const y = e.clientY;
    comet.style.left = `${x}px`;
    comet.style.top = `${y}px`;

    const trailX = (Math.random() - 0.5) * 20;
    const trailY = (Math.random() - 0.5) * 20;
    comet.style.setProperty('--trail-x', `${trailX}px`);
    comet.style.setProperty('--trail-y', `${trailY}px`);

    comet.style.animation = `comet-trail 1s forwards`;

    setTimeout(() => {
        comet.remove();
    }, 1000);
});
document.addEventListener('DOMContentLoaded', function () {
    const buttons = document.querySelectorAll('.circle-button');
    const content = document.getElementById('square-content');
    const container = document.querySelector('.square-container');
    const customButton = document.querySelector('.custom-button');
    const newModal = document.getElementById('new-modal');
    const closeButton = newModal.querySelector('.new-close-button');
    const modalLeft = newModal.querySelector('.modal-left');
    const modalRight = newModal.querySelector('.modal-right');
    const confirmButton = document.getElementById('confirm-button');
    const loadingModal = document.getElementById('new-loading-modal');
    const newInputModal = document.getElementById('new-input-modal');
    const newCloseButton = document.querySelector('.new-input-modal .new-close-button');
    const submitInfoButton = document.getElementById('submit-info-button');
    const forYouImage = document.querySelector('img[alt="For You Image"]');
    const forSomeoneElseImage = document.querySelector('img[alt="For Someone Else Image"]');

    let isSomeoneElseSelected = false;

    function loadContent(fileName) {
        if (fileName) {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', fileName, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    content.innerHTML = xhr.responseText;
                    content.scrollTop = 0;
                }
            };
            xhr.send();
        }
    }

    loadContent('contents-for-eastern-feature-1/content-default.html');

    buttons.forEach(button => {
        button.addEventListener('click', function () {
            buttons.forEach(btn => {
                btn.classList.remove('selected');
                btn.querySelector('.glow-effect').classList.remove('glow-animation');
            });

            this.classList.add('selected');
            this.querySelector('.glow-effect').classList.add('glow-animation');

            container.classList.remove('fire-selected', 'water-selected', 'earth-selected', 'metal-selected', 'wood-selected');
            let fileName;
            if (this.id === 'fire-button') {
                fileName = 'contents-for-eastern-feature-1/content-fire.html';
                container.classList.add('fire-selected');
            } else if (this.id === 'water-button') {
                fileName = 'contents-for-eastern-feature-1/content-water.html';
                container.classList.add('water-selected');
            } else if (this.id === 'earth-button') {
                fileName = 'contents-for-eastern-feature-1/content-earth.html';
                container.classList.add('earth-selected');
            } else if (this.id === 'metal-button') {
                fileName = 'contents-for-eastern-feature-1/content-metal.html';
                container.classList.add('metal-selected');
            } else if (this.id === 'wood-button') {
                fileName = 'contents-for-eastern-feature-1/content-wood.html';
                container.classList.add('wood-selected');
            }

            loadContent(fileName);
        });
    });

    customButton.addEventListener('click', function () {
        newModal.style.display = 'block';
    });

    closeButton.addEventListener('click', function () {
        newModal.style.display = 'none';
        newInputModal.style.display = 'none';
        loadingModal.style.display = 'none';
    });

    window.addEventListener('click', function (event) {
        if (event.target === newModal) {
            newModal.style.display = 'none';
        }
        if (event.target === newInputModal) {
            newInputModal.style.display = 'none';
        }
        if (event.target === loadingModal) {
            loadingModal.style.display = 'none';
        }
    });

    modalLeft.addEventListener('click', function () {
        modalLeft.classList.add('selected');
        modalRight.classList.remove('selected');
        isSomeoneElseSelected = false;
        document.getElementById('selectedOption').value = 'self';  // Đặt giá trị cho input hidden
    });

    modalRight.addEventListener('click', function () {
        modalRight.classList.add('selected');
        modalLeft.classList.remove('selected');
        isSomeoneElseSelected = true;
        document.getElementById('selectedOption').value = 'someoneElse';  // Đặt giá trị cho input hidden
    });

    confirmButton.addEventListener('click', function () {
        if (isSomeoneElseSelected) {
            newModal.style.display = 'none';
            newInputModal.style.display = 'block';
        } else {
            window.location.href = 'eastern-feature-1';  // Chuyển đến Servlet
        }
    });

    newCloseButton.addEventListener('click', function () {
        newInputModal.style.display = 'none';
    });

    forYouImage.addEventListener('click', function () {
        isSomeoneElseSelected = false;
    });

    forSomeoneElseImage.addEventListener('click', function () {
        isSomeoneElseSelected = true;
        newModal.style.display = 'none';
        newInputModal.style.display = 'block';
    });

    submitInfoButton.addEventListener('click', function () {
        const fullName = document.getElementById('full-name').value;
        const gender = document.getElementById('gender').value;
        const birthdate = document.getElementById('birthdate').value;

        if (fullName && gender && birthdate) {
//            alert(`Full Name: ${fullName}\nGender: ${gender}\nBirthdate: ${birthdate}`);
            window.location.href = 'eastern-feature-1';  // Chuyển đến Servlet
        } else {
            alert('Please fill in all fields.');
        }
    });
});

// chinh cho di chuyen qua servlet
document.addEventListener('DOMContentLoaded', function () {
    const confirmButton = document.getElementById('confirm-button');
    const selectedOptionInput = document.getElementById('selectedOption');
    const modalLeft = document.querySelector('.modal-left');
    const modalRight = document.querySelector('.modal-right');
    let isSomeoneElseSelected = false;

    modalLeft.addEventListener('click', function () {
        modalLeft.classList.add('selected');
        modalRight.classList.remove('selected');
        isSomeoneElseSelected = false;
        selectedOptionInput.value = 'self';
    });

    modalRight.addEventListener('click', function () {
        modalRight.classList.add('selected');
        modalLeft.classList.remove('selected');
        isSomeoneElseSelected = true;
        selectedOptionInput.value = 'someoneElse';
    });

    confirmButton.addEventListener('click', function () {
        if (isSomeoneElseSelected) {
            selectedOptionInput.value = 'someoneElse';
        } else {
            selectedOptionInput.value = 'self';
        }
        document.getElementById('form-id').submit();
    });
});

// chinh ngay toi da cho ban chon ngay sinh
document.addEventListener('DOMContentLoaded', () => {
    const today = new Date().toISOString().split('T')[0]; // Get today's date in YYYY-MM-DD format
    document.getElementById('birthdate').setAttribute('max', today);
});
// Function to show the modal
function showModal() {
    document.getElementById('result-loading-modal').classList.add('show');
}

// Call the function to show the modal (you can call this function as needed in your application)
document.getElementById('back-button').addEventListener('click', function () {
    document.getElementById('result-loading-modal').classList.remove('show');
    document.getElementById('background-blur').classList.remove('show');
});

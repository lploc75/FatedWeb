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

document.addEventListener('DOMContentLoaded', (event) => {
    const modal = document.getElementById("card-modal");
    const drawCardBtn = document.querySelector(".draw-card");
    const closeBtn = document.querySelector(".close-button");
    const confirmDrawBtn = document.querySelector(".confirm-draw");
    let selectedCard = null;

    confirmDrawBtn.disabled = true;

    drawCardBtn.onclick = function () {
        modal.style.display = "block";
    };

    closeBtn.onclick = function () {
        modal.style.display = "none";
    };

    confirmDrawBtn.onclick = function () {
        if (selectedCard) {
            document.getElementById("card-image").src = selectedCard.src;
            modal.style.display = "none";
        }
    };

    window.onclick = function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };

    document.querySelectorAll('.confirm-draw').forEach(button => {
        button.addEventListener('click', function () {
            document.getElementById('card-modal').style.display = 'none';
            document.getElementById('loading-modal').style.display = 'inline';
            setTimeout(() => {
                document.getElementById('loading-modal').style.display = 'none';
                // Add code here to handle post-loading actions
            }, 4000); // Adjust the timeout as needed
        });
    });

    document.querySelector('.close-button').addEventListener('click', function () {
        document.getElementById('card-modal').style.display = 'none';
    });

    window.onclick = function (event) {
        if (event.target === document.getElementById('card-modal')) {
            document.getElementById('card-modal').style.display = 'none';
        }
        if (event.target === document.getElementById('loading-modal')) {
            document.getElementById('loading-modal').style.display = 'none';
        }
    };

    const cards = document.querySelectorAll('.draw-card-image');
    cards.forEach(card => {
        card.addEventListener('click', function () {
            if (selectedCard) {
                selectedCard.classList.remove('selected');
            }
            card.classList.add('selected');
            selectedCard = card;
            confirmDrawBtn.disabled = false;
        });
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const cards = document.querySelectorAll('.draw-card-image');
    let selectedCard = null;

    cards.forEach(card => {
        card.addEventListener('click', function () {
            if (selectedCard) {
                selectedCard.classList.remove('selected');
            }
            card.classList.add('selected');
            selectedCard = card;
        });
    });
});

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
    function createShootingStar(direction) {
        const star = document.createElement('div');
        star.classList.add('shooting-star');
        if (direction === 'left') {
            star.classList.add('shooting-star-left');
        } else {
            star.classList.add('shooting-star-diagonal');
        }
        star.style.top = `${Math.random() * 10}%`;  // Giới hạn vị trí ngẫu nhiên theo chiều dọc trong 10%
        star.style.left = `${Math.random() * 100}%`; // Vị trí ngẫu nhiên theo chiều ngang
        const modalContent = document.querySelector('.modal-content');

        modalContent.appendChild(star);

        // Animate star
        star.style.animationDuration = `${Math.random() * 2 + 2}s`;

        setTimeout(() => {
            star.remove();
        }, 5000); // Xóa sao sau khi hoàn thành chuyển động
    }

    // Tạo nhiều sao băng
    setInterval(() => createShootingStar('diagonal'), 250); // Sao băng chéo xuống
    setInterval(() => createShootingStar('left'), 300); // Sao băng chéo về bên trái
});

document.addEventListener('DOMContentLoaded', function () {
    function createShootingStar(direction) {
        const star = document.createElement('div');
        star.classList.add('shooting-star');
        if (direction === 'left') {
            star.classList.add('shooting-star-left');
        } else {
            star.classList.add('shooting-star-diagonal');
        }
        star.style.top = `${Math.random() * 10}%`;  // Giới hạn vị trí ngẫu nhiên theo chiều dọc trong 10%
        star.style.left = `${Math.random() * 100}%`; // Vị trí ngẫu nhiên theo chiều ngang
        const modalContent = document.querySelector('.loading-content');

        modalContent.appendChild(star);

        // Animate star
        star.style.animationDuration = `${Math.random() * 2 + 2}s`;

        setTimeout(() => {
            star.remove();
        }, 5000); // Xóa sao sau khi hoàn thành chuyển động
    }

    // Tạo nhiều sao băng
    setInterval(() => createShootingStar('diagonal'), 250); // Sao băng chéo xuống
    setInterval(() => createShootingStar('left'), 300); // Sao băng chéo về bên trái
});

function calculateMoonPhase(year, month, day) {
    if (month < 3) {
        year--;
        month += 12;
    }
    const a = Math.floor(year / 100);
    const b = 2 - a + Math.floor(a / 4);
    const jd = Math.floor(365.25 * (year + 4716)) + Math.floor(30.6001 * (month + 1)) + day + b - 1524.5;

    const daysSinceNewMoon = jd - 2451550.1;
    const newMoonCycle = daysSinceNewMoon / 29.53058867;
    const newMoonCycleRounded = Math.round(newMoonCycle);

    const moonPhase = newMoonCycle - newMoonCycleRounded;
    return Math.abs(moonPhase);
}
function alertFeatureLocked() {
    alert("Feature locked, go to membership and get Vip or Vip++ rank to unlock!");
}
function getMoonPhaseName(phase) {
    if (phase < 0.02 || phase > 0.98) {
        return "New Moon";
    } else if (phase < 0.25) {
        return "Waxing Crescent";
    } else if (phase < 0.27) {
        return "First Quarter";
    } else if (phase < 0.50) {
        return "Waxing Gibbous";
    } else if (phase < 0.52) {
        return "Full Moon";
    } else if (phase < 0.75) {
        return "Waning Gibbous";
    } else if (phase < 0.77) {
        return "Last Quarter";
    } else {
        return "Waning Crescent";
    }
}

function getMoonPhaseImage(phaseName) {
    const imageMap = {
        "New Moon": "./assets/images/moon-phases/new-moon.png",
        "Waxing Crescent": "./assets/images/moon-phases/cresent.png",
        "First Quarter": "./assets/images/moon-phases/Quarter.png",
        "Waxing Gibbous": "./assets/images/moon-phases/gibbous.png",
        "Full Moon": "./assets/images/moon-phases/full-moon.png",
        "Waning Gibbous": "./assets/images/moon-phases/gibbous.png",
        "Last Quarter": "./assets/images/moon-phases/Quarter.png",
        "Waning Crescent": "./assets/images/moon-phases/Cresent.png"
    };
    return imageMap[phaseName];
}

document.addEventListener('DOMContentLoaded', (event) => {
    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    const day = today.getDate();

    const phase = calculateMoonPhase(year, month, day);
    const phaseName = getMoonPhaseName(phase);
    const moonPhaseImage = getMoonPhaseImage(phaseName);

    const moonPhaseImageElement = document.getElementById('moon-phase-image');
    moonPhaseImageElement.src = moonPhaseImage;
    moonPhaseImageElement.alt = phaseName;
});
document.addEventListener('DOMContentLoaded', (event) => {
    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    const day = today.getDate();

    const phase = calculateMoonPhase(year, month, day);
    const phaseName = getMoonPhaseName(phase);
    const moonPhaseImage = getMoonPhaseImage(phaseName);

    const moonPhaseImageElement = document.getElementById('moon-phase-image');
    moonPhaseImageElement.src = moonPhaseImage;
    moonPhaseImageElement.alt = phaseName;

    const currentMoonPhaseElement = document.getElementById('current-moon-phase');
    currentMoonPhaseElement.textContent = phaseName;
});
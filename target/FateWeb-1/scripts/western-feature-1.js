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
    const calendarElement = document.getElementById('calendar');
    const calendarTitle = document.getElementById('calendar-title');
    const prevMonthButton = document.getElementById('prev-month');
    const nextMonthButton = document.getElementById('next-month');

    let date = new Date();
    let month = date.getMonth();
    let year = date.getFullYear();

    function generateCalendar(month, year) {
        const daysInMonth = new Date(year, month + 1, 0).getDate();
        const firstDay = new Date(year, month, 1).getDay();

        let calendarHtml = '<table class="calendar"><thead><tr><th>CN</th><th>Hai</th><th>Ba</th><th>Tư</th><th>Năm</th><th>Sáu</th><th>Bảy</th></tr></thead><tbody><tr>';

        for (let i = 0; i < firstDay; i++) {
            calendarHtml += '<td></td>';
        }

        for (let day = 1; day <= daysInMonth; day++) {
            const currentDay = new Date(year, month, day).getDay();
            const isToday = day === date.getDate() && month === date.getMonth() && year === date.getFullYear();

            calendarHtml += `<td class="${isToday ? 'today' : ''}">${day}</td>`;

            if (currentDay === 6 && day !== daysInMonth) {
                calendarHtml += '</tr><tr>';
            }
        }

        calendarHtml += '</tr></tbody></table>';
        calendarElement.innerHTML = calendarHtml;
        updateCalendarTitle(month, year);
    }

    function updateCalendarTitle(month, year) {
        const monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        calendarTitle.textContent = `${monthNames[month]} ${year}`;
    }

    prevMonthButton.addEventListener('click', () => {
        if (month === 0) {
            month = 11;
            year--;
        } else {
            month--;
        }
        generateCalendar(month, year);
    });

    nextMonthButton.addEventListener('click', () => {
        if (month === 11) {
            month = 0;
            year++;
        } else {
            month++;
        }
        generateCalendar(month, year);
    });

    generateCalendar(month, year);
});


document.addEventListener('DOMContentLoaded', (event) => {
    const modal = document.getElementById("card-modal");
    const confirmDrawBtn = document.querySelector(".confirm-draw");
    const cardImage = document.getElementById("card-image");
    const cardDescription = document.getElementById("card-description");
    const interpretationText = document.getElementById("interpretation-text");
    const interpretationContainer = document.getElementById("card-interpretation");

    const cards = [
        {id: 'card1', image: 'path/to/card1.jpg', description: 'Mô tả cho lá bài 1'},
        {id: 'card2', image: 'path/to/card2.jpg', description: 'Mô tả cho lá bài 2'},
        {id: 'card3', image: 'path/to/card3.jpg', description: 'Mô tả cho lá bài 3'},
                // Thêm các lá bài khác ở đây
    ];

    let selectedCard = null;

    function getRandomCard() {
        const randomIndex = Math.floor(Math.random() * cards.length);
        return cards[randomIndex];
    }

    document.querySelectorAll('.card').forEach(card => {
        card.addEventListener('click', () => {
            document.querySelectorAll('.card').forEach(c => c.classList.remove('selected'));
            card.classList.add('selected');
            selectedCard = cards.find(c => c.id === card.id);
        });
    });

    document.querySelectorAll('.question-button').forEach(button => {
        button.addEventListener('click', (e) => {
            if (selectedCard) {
                const question = button.getAttribute('data-question');
                console.log(`Người dùng đã chọn: ${question}`);
                interpretationText.textContent = selectedCard.description;
                interpretationContainer.style.display = 'block';
            } else {
                alert('Hãy chọn một lá bài trước!');
                e.preventDefault(); // Ngăn chặn việc gửi form nếu không có lá bài được chọn
            }
        });
    });



    confirmDrawBtn.onclick = function () {
        modal.style.display = "none";
    };

    window.onclick = function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };
});

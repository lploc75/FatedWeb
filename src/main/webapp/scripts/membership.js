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
function alertFeatureLocked() {
    alert("Feature locked, go to membership and get Vip or Vip++ rank to unlock!");
}


function setTranslate(xPos, yPos, el) {
    el.style.transform = "translate3d(" + xPos + ", " + yPos + "px, 0)";
}

window.addEventListener("DOMContentLoaded", scrollLoop, false);

let xScrollPosition;
let yScrollPosition;

function scrollLoop() {
    let backOne = document.getElementById("back_one");
    let backTwo = document.getElementById("back_two");
    let main = document.getElementById("main");
    let content = document.getElementById("fill_content");
    let preview = document.getElementById("preview_text");
    xScrollPosition = window.scrollX;
    yScrollPosition = window.scrollY;

    setTranslate(0, yScrollPosition * -0.1, backOne);
    setTranslate(0, yScrollPosition * -0.3, backTwo);
    setTranslate(0, yScrollPosition * -0.35, main);
    setTranslate(0, yScrollPosition * -0.5, content);
    setTranslate(0, yScrollPosition * 0.35, preview);

    requestAnimationFrame(scrollLoop);
}
const zero = 200;
let r_now=1;
const r_const = 48;
document.addEventListener("DOMContentLoaded", function(event) {
    getValueCanvas();
    drawBatman(r_now);
});

function drawBatman (r) {
    let canvas = document.getElementById('paintCanvas');
    let context = canvas.getContext('2d');
    context.clearRect(0,0,400,400);
    let kof = (4 - r)*0.25*400;
    r_now = r;
    context.drawImage(document.getElementById('batman'), kof/2, kof/2, 400-kof, 400-kof);

}

function getValueCanvas() {
    let canvas = document.getElementById('paintCanvas');
    if (canvas.getContext) {

        canvas.addEventListener('click', canvasClicked, false);

        function canvasClicked(e) {
            let rect = canvas.getBoundingClientRect();
            let x = e.clientX - rect.left;
            let y = e.clientY - rect.top;
            let ord = r_now*r_const;

            if (x >= zero) {
                x = x - zero
            } else {
                x = -(zero - x);
            }

            if (y <= zero) {
                y = zero - y;
            } else {
                y = -(y - zero);
            }

            x=x/ord;
            y=y/ord;
            drawPoint(1,1,x,y,r_now);
            document.getElementById('j_idt7:Y').value = y;
            let new_x = document.getElementById("j_idt7:X:"+(4+x));
            console.log(x);
            new_x.checked = true;
            document.getElementById('j_idt7:submit').click();
        }

    }
}

//метод рисует точку по данным

function drawPoint(correct, isIn, x, y ,r) {
    let xCanvas = 0;
    let yCanvas = 0;
    if (correct!=='0'){
        let ord = r*r_const;
        x = x*ord;
        y= y*ord;
        xCanvas = 200 + x;
        yCanvas = 200 - y;

        pointDrawCanvas(isIn, xCanvas,yCanvas, r);
    }
}

function pointDrawCanvas(isIn, xCanvas, yCanvas,r ) {
    let canvas = document.getElementById('paintCanvas');
    if (canvas.getContext) {
        let ctx = canvas.getContext('2d');
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        drawBatman(r);
        ctx.beginPath();

        if (isIn!==0){
            ctx.fillStyle = "#470005";}
        else {
            ctx.fillStyle = "rgba(91,234,65,0.68)";
        }
        ctx.moveTo(125, 35);
        ctx.arc(xCanvas, yCanvas, 4, 0, 2 * Math.PI);
        ctx.fill();
    }
}
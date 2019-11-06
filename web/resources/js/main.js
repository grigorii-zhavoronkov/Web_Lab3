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
    console.log("hfdbjsdnfl");
     let canvas = document.getElementById('paintCanvas');
     if (canvas.getContext) {

         canvas.addEventListener('click', canvasClicked, false);

         function canvasClicked(e) {

             let x = e.pageX - e.target.offsetLeft;
             let y = e.pageY - e.target.offsetTop;
             let r = r_now*r_const;

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

             x=Math.round(x/r);
             y=y/r;

             if ([ -4, -3, -2, -1, 0, 1, 2, 3, 4].includes(x) && (-3 < y) && (y < 5)) {
                 document.getElementById('j_idt7:Y').value = y;
                 let new_x = document.getElementById("j_idt7:X:"+(4+x));
                 console.log(x);
                 new_x.checked = true;
                 document.getElementById('j_idt7:submit').click();
             }
         }

     }
 }

 //метод рисует точку по данным

function drawPoint(correct, isIn, x, y ,r) {
    let xCanvas = 0;
    let yCanvas = 0;
    if (correct!=='0'){
        if (x<0){
            xCanvas = 200 - Math.abs(x)*r*48;
        } else {

            xCanvas = 200 + x*r*48;
        }
        if (y<0){
            yCanvas = 200 + Math.abs(y)*r*480;
        } else {
            yCanvas = 200 - y*r*48;
        }

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
        ctx.arc(xCanvas, yCanvas, 6, 0, 2 * Math.PI);
        ctx.fill();
    }
}


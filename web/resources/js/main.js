const zero = 200;
let r_now;
const r_const = 48;
document.addEventListener("DOMContentLoaded", function(event) {
    getValueCanvas();
    drawBatman(1);
});

function drawBatman (r) {
    let canvas = document.getElementById('paintCanvas');
    let context = canvas.getContext('2d');
    context.clearRect(0,0,400,400);
    let kof = (4 - r)*0.25*400;
    r_now = r;
    //console.log(r);
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
                 //document.forms["j_idt7"].submit();
                 document.getElementById('j_idt7:submit').click();
             }
            //console.log("x "+x/r+"y "+y/r+" r "+r);
         }

     }
 }
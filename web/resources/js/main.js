 function drawBatman (r) {
    var canvas = document.getElementById('paintCanvas');
    var context = canvas.getContext('2d');
    context.clearRect(0,0,400,400);
    var kof = (4 - r)*0.25*400;
    console.log(r);
    context.drawImage(document.getElementById('batman'), kof/2, kof/2, 400-kof, 400-kof);

};


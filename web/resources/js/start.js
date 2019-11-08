function updateTime() {
    let now = new Date();
    let text_time = now.getDate() + "/" + now.getMonth() + "/" + now.getFullYear() + "<br>" + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
    document.getElementsByClassName("time_gavno")[0].innerHTML = text_time;
}

setInterval(updateTime, 8000);
$ = jQuery;
$(window).scroll(function(){

    var st = $(this).scrollTop();

   $("#test").css({
       "transform" : "translate( 0%, " + (st/10) + "%"
    })

    $("#first_parallax").css({
        "transform" : "translate( 0%, -" + (st/10) + "%"
    })
    $("#sec_parallax").css({
        "transform" : "translate( 0%, -" + (st/5) + "%"
    })
    $("#third_parallax").css({
        "transform" : "translate( 0%, -" + (st/3) + "%"
    })
});
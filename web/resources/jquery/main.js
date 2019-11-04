$ = jQuery;
$(window).scroll(function(){

    var st = $(this).scrollTop();
    console.log(st);
        $("#test").css({
            "transform": "translate( 0%, " + (st / 10) + "%"
        })

        $("#first_parallax").css({
            "transform": "translate( 0%, -" + (st / 30) + "%"
        })
        $("#sec_parallax").css({
            "transform": "translate( 0%, -" + (st / 20) + "%"
        })
        $("#third_parallax").css({
            "transform": "translate( 0%, -" + (st / 19.98) + "%"
        });

});
$ = jQuery;

$(window).scroll(function(){

    var sсrolled = $(this).scrollTop();
    $('#preview_text').css('top',((sсrolled*.1))+'px');
    $('#back_one').css('top',(0-(sсrolled*.2))+'px');
    $('#back_two').css('top',(0-(sсrolled*.5))+'px');
    $('#main').css('top',(0-(sсrolled*.8))+'px');
    $('#fill_content').css('top',(0-(sсrolled*.65))+'px');

});


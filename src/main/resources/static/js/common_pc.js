/**
 * Created by 大丽丽 on 2017/2/13.
 */
$('.newsUl li:nth-child(even)').css('background','#fff');

$('#contractId').click(function(){
    $('.dealDel').fadeIn();
});
$('.close').click(function(){
    $('.dealDel').fadeOut();
});
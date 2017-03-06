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


//限制方法
function max(yuan,len){
    var y=$(yuan);
    for( var i= 0,maxwidth=len;i< y.length;i++ ){
        if(y[i].innerHTML.length>maxwidth){
            y[i].innerHTML=y[i].innerHTML.substring(0,maxwidth)+'...';
        }
    }
}
//合约
max('.newsInfo>a:first-child',15);
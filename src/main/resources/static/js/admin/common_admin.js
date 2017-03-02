/**
 * Created by 大丽丽 on 2017/2/14.
 */
//登录
$('#passWord').blur(function(){
    if($('.loginYi input').val()!==''){
       // $('.alertCon').css('display','block');
    }
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
max('.mineContract',10);
max('.conName.mineContract',9);
max('.contractName',9);
max('.conID',10);
max('.contractID',8);
max('.conWhere',8);


//hover
$( ".mineDel li:not(:first-child)" ).hover(
    function() {
        //console.log($(this).hasClass('mineCur'))
        if( !($(this).hasClass('mineCur')) ){
            $( this ).addClass('hover');
        }

    }, function() {
        $( this ).removeClass('hover');
    }
);


//我的账本
$('.mineDel li:not(:first-child)').click(function(){
    $(this).siblings().removeClass('mineCur');
    $(this).siblings().children().removeClass('mineWhite');

    $(this).removeClass('hover').unbind('hover');

    $(this).addClass('mineCur');
    $(this).children().addClass('mineWhite');
});

//捐献合约
$('.conDel li:not(:first-child)').click(function(){
    $(this).siblings().removeClass('conCur');
    $(this).addClass('conCur');
});

//施工合同
$('.contractUl li:not(:first-child)').click(function(){
    $(this).siblings().removeClass('contractCur');
    $(this).addClass('contractCur');
});






























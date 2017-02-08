/**
 * Created by 大丽丽 on 2016/11/8.
 */
function dlClick(obj){
//        alert(1)
    if( !$(obj).find('dd').hasClass('footDlAct') ){
        $(obj).find('dd').addClass('footDlAct');
    }
    if( $(obj).parent().siblings().find('dd').hasClass('footDlAct') ){
        $(obj).parent().siblings().find('dd').removeClass('footDlAct');
    }

    if( $(obj).find('span').attr('class').indexOf('_act')=='-1' ){
//            alert(1)
        var cla=$(obj).find('span').attr('class');

//            var arr=$(obj).parent().siblings().find('span').attr('class');
//            var subArr=arr.slice(0,-4);
//            $(obj).parent().siblings().find('span').removeClass();

        $(obj).find('span').attr('class',cla+'_act');
//            console.log( subArr);
    }

//        if( !$(obj).parent().siblings().find('span').attr('class').indexOf('_act')=='-1' ){
//            alert(1)
////            var cla=$(obj).find('span').attr('class');
////            $(obj).find('span').attr('class',cla+'_act');
////            console.log( $(obj).find('span').attr('class'));
//        }

}

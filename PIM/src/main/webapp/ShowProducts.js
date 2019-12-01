$(document).ready(function() {
    $(".description").click(function(){
    var tag = $(this);
    if(tag.hasClass("expanded")){
    tag.removeClass("expanded");
    } 
    else {
    tag.addClass("expanded");
    }
    });
});
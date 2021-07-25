var list={
    setcolor: function (color){
    var alist=document.querySelectorAll('a');
    var i=0;
    while(i<alist.length){
        alist[i].style.color=color;
        i++;
    }
}
}
var body={
    setbackgroundcolor: function (color){
    document.querySelector('body').style.backgroundColor=color;
},
    setcolor:function (color){
    document.querySelector('body').style.color=color;
}
}   


function s(self){
var target=document.querySelector('body').style;
if(self.value==='night')
{
    body.setbackgroundcolor('black');
    body.setcolor('white');
    self.value='day';
    list.setcolor('powderblue');
}
else
{   
    body.setbackgroundcolor('white');
    body.setcolor('black');
    self.value='night';
    list.setcolor('blue');
    
}
}
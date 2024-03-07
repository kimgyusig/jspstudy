/**
 * 
 */

const getContextPath = ()=>{
  
  const host = location.host; /*localthost:8080 */
  const url = location.href; /*http://localhost:8080/mvc/getDate.do*/
  const begin = url.indexOf(host) + host.length;
  const end = url.indexOf('/', begin + 1); //m부터
  return url.substring(begin, end); // begin:/은 포함되고 end:/ 는 포함되지 않는다
}



 const getDateTime = ()=>{
   const type = document.getElementById('type');
   if(type.value === 'date'){
     location.href = getContextPath() + '/getDate.do';
   } else if(type.value === 'time'){
     location.href= getContextPath() + '/getTime.do';
   } else if(type.value === 'datetime'){
     location.href = getContextPath() + '/getDateTime.do';
   }
 }
 
document.getElementById('btn').addEventListener('click', getDateTime);
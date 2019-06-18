/*-----------------------------------------------------通用方法区域----------------------------------*/
const publicMethods = {
  isDataNull(value) {
  if(value != null || value != "" || value != undefined){
    return true;
  }else {
    return false;
  }
}
};
export default publicMethods



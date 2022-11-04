/* 登録ボタンを押下 */
window.onload = function () {
/* 戻るボタンを押下 */
document.getElementById('returnButton').onclick = function() {
  // TOP画面へ遷移
  window.location.href = 'http://localhost:8080/trip/topView';
};
};
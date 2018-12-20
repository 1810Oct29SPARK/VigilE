let view_indicator = document.getElementById("view-indicator");
let shift_time = document.getElementById("shift-time");
let request_count = document.getElementById("request-count");

function start() {
    calendar();
    setShift('6:00pm', '9:00pm');
}
// this function will find today's date
function calendar(){
    var day = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    var month = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    var d = new Date();
    setText('calendar-day', day[d.getDay()]);
    setText('calendar-date', d.getDate());
    setText('calendar-month-year', month[d.getMonth()] + ' ' + (1900 + d.getYear()));

};

// this function will set the text value of <p> tags
function setText(id, val){
    if (val < 10) {
        val = '0' + val; // add leading 0 if val < 10
    }
    document.getElementById(id).innerHTML = val;
};

function setShift(start_time, end_time) {
    var start = start_time;
    var end = end_time;
    document.getElementById('shift-time').innerHTML = start_time + ' - ' + end_time;
}
// call calendar when page loads
window.onload = start;

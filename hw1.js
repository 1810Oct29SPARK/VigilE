/* function arraySort (arr) {
    let array = arr;
    // use a loop to sort through the array
    for (i = 0: i < array.length; i++) {
        // compare each of the elements in the array to array[0]
        if (array[0] >= array[i]){


        }

    }
}
*/

function bubbleSort(array) {
    var done = true;
    while (done) {
      done = false;
      for (var i = 1; i < array.length; i++) {
        if (array[i - 1] > array[i]) {
          done = true;
          var tmp = array[i - 1];
          array[i - 1] = array[i];
          array[i] = tmp;
        }
        console.log("Run " + i + ":");
        console.log(array);
      }
    }
    return array;
  }
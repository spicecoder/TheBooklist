<template>
  <div v-if="this.book">
    <h4>Book</h4>
    <div>
      <label>Title: </label> {{this.book.title}}
    </div>
    <div>
      <label>Author: </label> {{this.book.author}}
    </div>
    <div>
      <label> ISBN: </label> {{this.book.ISBN}}
    </div>
  </div>
  <div v-else >
    <br/>
    <p>Please click on a Book...</p>
  </div>
 
</template>

<script>


export default {
  name: "book",
  props: ["book"],
  methods: {
    /* eslint-disable no-console */

    /* eslint-enable no-console */
  }
};
</script>
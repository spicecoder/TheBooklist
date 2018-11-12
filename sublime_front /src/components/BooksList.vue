<template>
    <div class="container">
            <h2>Book List</h2>
            
   <table class="table">
    <thead>
      <tr>
        <th>Title</th>
        <th >Author</th>
        <th >ISBN</th>
      </tr>
    </thead>
    <tbody>
   
    <tr v-for="(book, index) in books" :key="index">
              
        <td>{{book.title}}</td>
        <td >{{book.author}}</td>
        <td >{{book.isbn}}</td>
                </tr>       
            </tbody>
      </table>       
    </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "book-list",
  data() {
    return {
      books: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    retrieveBooks() {
      http
        .get("/books")
        .then(response => {
          this.books = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveBooks();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.retrieveBooks();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>

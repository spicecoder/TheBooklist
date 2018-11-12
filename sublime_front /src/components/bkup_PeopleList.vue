<template>
    <div class="container">
            <h2>People c List</h2>
   <table class="table">
    <thead>
      <tr>
        <th>Borrowed</th>
        <th>Name</th>
        <th >Phone</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
   
    <tr v-for="(person, index) in people" :key="index">
              
       <td>
       <button v-on:click="borrow">?</button>
       </td>
        <td>{{person.name}}</td>
       
        <td >{{person.phone}}</td>
        <td >{{person.email}}</td>
                </tr>       
            </tbody>
      </table>       
    </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "people-list",
  data() {
    return {
      people: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    retrievePeople() {
      http
        .get("/people")
        .then(response => {
          this.people = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    retrieveBorrowed() {
      http
        .get("/books/borrowedby/" + this.email)
        .then(response => {
          //this.borrowed = response.data; // JSON are parsed automatically.
          console.log(response.data);
          console.log(this.borrowed);
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    refreshList() {
      this.retrievePeople();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.retrievePeople();
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

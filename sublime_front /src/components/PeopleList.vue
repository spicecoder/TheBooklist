<template>
    <div class="container">
            <h2>People  List</h2>
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
       <span  v-on:click="retrieveBorrowed(person.email,index,$event)"> ? </span>
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
var Vue = require('vue');

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
          this.people = response.data; // JSON parsed.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    retrieveBorrowed(email,index,e) {
    const element = e.target;
   // if (this.isShowing == false) {

      http
        .get("/books/borrowedby/" + email)
        .then(response => {
          //this.borrowed = response.data; // JSON parsed.
          
          
      var booknames ="<ul>";

for ( let i = 0; i < response.data.length; i++ ) {
       booknames = booknames + "<li>" + response.data[i].title +"</li>";
       
       }
      
       element.outerHTML = booknames + "</ul>"; 
      // this.isShowing = true ; 
       })
       .catch(e => {
          console.log(e);
        });

  //     }
  //  else {
   //      element.outerHTML = "?";
  //       this.isShowing = false;
  //  
  //  }   
  const compiled = Vue.compile( element.outerHTML );
  new Vue( {
    el: element,
    render: compiled.render
  } );
              
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

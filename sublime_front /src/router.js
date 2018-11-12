import Vue from "vue";
import Router from "vue-router";
import PeopleList from "./components/PeopleList.vue";
import BooksList from "./components/BooksList.vue";
import Person from "./components/Person.vue";
import Book from "./components/Book.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
     {
      path: "/",
      name: "people",
      alias: "/person",
      component: PeopleList,
      children: [
        {
          path: "/person/:id",
          name: "person-details",
          component: Person,
          props: true
        }
      ]
    },
    
    {
      path: "/books",
      name: "books",
      alias: "/book",
      component: BooksList,
      children: [
        {
          path: "/book/:id",
          name: "book-details",
          component: Book,
          props: true
        }
      ]
    }

  ]
});
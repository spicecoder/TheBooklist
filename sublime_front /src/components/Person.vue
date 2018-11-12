<template>
  <div v-if="this.person">
    <h4>Person</h4>
    <div>
      <label>Name: </label> {{this.person.name}}
    </div>
    <div>
      <label>Email: </label> {{this.person.email}}
    </div>
    <div>
      <label>Phone: </label> {{this.person.phone}}
    </div>
  </div>
  <div v-else>
    <br/>
    <p>Please click on a Person...</p>
  </div>
</template>

<script>


export default {
  name: "person",
  props: ["person"],
  methods: {
    /* eslint-disable no-console */

    /* eslint-enable no-console */
  }
};
</script>
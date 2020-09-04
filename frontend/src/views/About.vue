<template>
  <main>
    <div class="about">
      <h1>This is an about page</h1>
      <button @click="callAPI">Call API</button>
      <h2>{{ greeting }}</h2>
    </div>
    <div class="select_all">
      <h1>select * from tastdb1</h1>
      <button @click="callSelectAll">Call "Select All"</button>
      <h2>{{ selectAllResult }}</h2>
    </div>
    <div class="insert">
      <h1>Insert into tastdb1 VALUES (id, name);</h1>
      <input id="insertId" v-model="insertId" number><input id="insertName" v-model="insertName" string>
      <p>insertId is: {{ insertId }}. insertName is: {{ insertName }}</p>
      <button @click="callInsert">insert data</button>
      <h2>{{ insertResult }}</h2>
    </div>
    <div class="update">
      <h1>UPDATE tastdb1 SET name = '' WHERE id = ;</h1>
      <input id="updateId" v-model="updateId" number><input id="updateName" v-model="updateName" string>
      <p>insertId is: {{ updateId }}. insertName is: {{ updateName }}</p>
      <button @click="callUpdate">update data</button>
      <h2>{{ updateResult }}</h2>
    </div>
    <div class="delete">
      <h1>DELETE FROM tastdb1 WHERE id = ;</h1>
      <input id="deleteId" v-model="deleteId" number>
      <p>deleteId is: {{ deleteId }}</p>
      <button @click="callDelete">delete data</button>
      <h2>{{ deleteResult }}</h2>
    </div>
  </main>
</template>

<script>
import axios from "axios";
export default {
  //name: "about"
  data() {
    return {
      greeting: "",
      selectAllResult: "",
      insertResult: "",
      updateResult: "",
      deleteResult: "",
      insertId: 0,
      insertName: "",
      updateId: 0,
      updateName: "",
      deleteId: 0
    };
  },
  methods: {
    callAPI() {
      axios
        .get("http://localhost:8888/helloworld")
        .then(resp => {
          this.greeting = resp.data;
        })
        .catch(err => {
          this.greeting = err;
        });
    },
    callSelectAll() {
        axios
          .get("http://localhost:8888/select_all")
          .then(resp => {
            this.selectAllResult = resp.data;
          })
          .catch(err => {
            this.selectAllResult = err;
          });
     },
    callInsert() {
        let insertId = document.getElementById("insertId").value;
        let insertName = document.getElementById("insertName").value;
        let url = "http://localhost:8888/insert/" + insertId + "/" + insertName
        axios
        .post(url)
          .then(resp => {
            this.insertResult = resp.data;
          })
          .catch(err => {
            this.insertResult = err;
          });
     },
    callUpdate() {
        let updateId = document.getElementById("updateId").value;
        let updateName = document.getElementById("updateName").value;
        let url = "http://localhost:8888/update/" + updateId + "/" + updateName
        axios
          .put(url)
          .then(resp => {
            this.updateResult = resp.data;
          })
          .catch(err => {
            this.updateResult = err;
          });
     },
    callDelete() {
        let deleteId = document.getElementById("deleteId").value;
        let url = "http://localhost:8888/delete/" + deleteId
        axios
          .delete(url)
          .then(resp => {
            this.deleteResult = resp.data;
          })
          .catch(err => {
            this.deleteResult = err;
          });
     }
  }
};
</script>
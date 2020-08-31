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
      <input v-model="insertId" number><input v-model="insertName" string>
      <p>insertId is: {{ insertId }}. insertName is: {{ insertName }}</p>
      <button @click="callInsert">insert data</button>
      <h2>{{ insertResult }}</h2>
    </div>
    <div class="update">
      <h1>UPDATE tastdb1 SET name = '' WHERE id = ;</h1>
      <button @click="callUpdate">Call "Select All"</button>
      <h2>{{ updateResult }}</h2>
    </div>
    <div class="delete">
      <h1>DELETE FROM tastdb1 WHERE id = ;</h1>
      <button @click="callDelete">Call "Select All"</button>
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
      insertName: ""
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
        const submitParams = new FormData();
        //insertId = this.insertId;
        //this.insertName = insertName;
        //submitParams.append('insertId',100);
        //submitParams.append('insertName',this.insertName);
        //console.log(insertId)
        console.log(submitParams)
        axios
        //.post("http://localhost:8888/insert/", submitParams)
        .post("http://localhost:8888/insert/100")
          //.post("http://localhost:8888/insert?id=#{insertId}&name=#{insertName}")
          //.post("http://localhost:8888/insert", submitParams)
          .then(resp => {
            this.insertResult = resp.data;
          })
          .catch(err => {
            this.insertResult = err;
          });
     },
    callUpdate() {
        axios
          .put("http://localhost:8888/select_all")
          .then(resp => {
            this.updateResult = resp.data;
          })
          .catch(err => {
            this.updateResult = err;
          });
     },
    callDelete() {
        axios
          .delete("http://localhost:8888/select_all")
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
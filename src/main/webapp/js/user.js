//实例化vue对象
var vue = new Vue({
    el: '#app',
    data: {
        pojo: {},// form表单数据绑定
        userList: []     // 用户列表数据, 后台要返回list   {}=>实体类或者map
    },
    created() {
        this.initData();
    },
    methods: {
        initData() {
            axios.get("/user/findAll").then(resp => {
                this.userList = resp.data;
            })
        },
        edit(uid) {
            this.pojo = {}; // 清空表单
            axios.get("/user/findById?uid=" + uid).then(resp => {
                this.pojo = resp.data;
            });
        },
        update() {
            // alert(JSON.stringify(this.pojo))
            var submitData = this.pojo;
            axios.post("/user/update",submitData).then(resp => {
                alert(resp.data.message);
                if (resp.data.flag) {
                    this.initData();
                }
            })
        },
    }

});
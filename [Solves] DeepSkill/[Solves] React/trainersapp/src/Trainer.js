class Trainer {
    constructor(trainerId, name, email, phone, technology, skills) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.technology = technology;
        this.skills = skills; 
    }
}
export default Trainer;

// ========= Notes ========= 
// let some = new Trainer(); <-- here we can pass parameters by order of [trainerId, name, email, phone, technology, skills]
// or
// let some = new Trainer({  <-- like this parameterized version also valid
//     trainerId: "",
//     name: "",
//     email: "",
//     phone: "",
//     technology: "",
//     skills: "",
// });
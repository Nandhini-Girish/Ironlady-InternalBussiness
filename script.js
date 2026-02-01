const api = "http://localhost:8080/api/learners";

function loadLearners() {
    fetch(api)
        .then(res => res.json())
        .then(data => {
            let rows = "";
            data.forEach(l => {
                rows += `
                <tr>
                    <td>${l.name}</td>
                    <td>${l.email}</td>
                    <td>${l.program}</td>
                    <td>${l.status}</td>
                    <td>
                        <button onclick="edit(${l.id}, '${l.name}', '${l.email}', '${l.program}', '${l.status}')">Edit</button>
                        <button onclick="remove(${l.id})">Delete</button>
                    </td>
                </tr>`;
            });
            document.getElementById("tableBody").innerHTML = rows;
        });
}

document.getElementById("form").onsubmit = function(e) {
    e.preventDefault();

    const id = document.getElementById("id").value;
    const learner = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        program: document.getElementById("program").value,
        status: document.getElementById("status").value,
    };

    fetch(id ? api + "/" + id : api, {
        method: id ? "PUT" : "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(learner)
    }).then(() => {
        this.reset();
        loadLearners();
    });
}

function edit(id, n, e, p, s) {
    document.getElementById("id").value = id;
    document.getElementById("name").value=n;
    document.getElementById("email").value=e;
    document.getElementById("program").value=p;
    document.getElementById("status").value=s;
    
}

function remove(id) {
    fetch(api + "/" + id, { method: "DELETE" })
        .then(loadLearners);
}

loadLearners();

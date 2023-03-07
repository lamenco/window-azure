const commentForm = document.getElementById('commentForm')

commentForm.addEventListener("submit", handleFormSubmission)
const csrfHeaderName = document.head.querySelector('[name=_csrf_header]').content
const csrfHeaderValue = document.head.querySelector('[name=_csrf]').content

const commentContainer = document.getElementById('commentCtnr')

async function handleFormSubmission(event) {
    event.preventDefault()

    const messageVal = document.getElementById('message').value
    fetch('http://localhost:8080/api/products/VIVA', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accepts': 'application/json',
            [csrfHeaderName]: csrfHeaderValue
        },
        body: JSON.stringify({
            message: messageVal
        })
    }).then(res => res.json())
        .then(data => {
            document.getElementById('message').value = "";
            commentContainer.innerHTML += commentAsHtml(data)
        })
}

function commentAsHtml(comment) {
    let commentHtml = '<div>\n'
    commentHtml += `<h4>${comment.authorName}</h4>\n`
    commentHtml += `<textarea readonly>${comment.text}</textarea readonly>\n`
    commentHtml += `</div>\n`
    return commentHtml
}

fetch(`http://localhost:8080/api/products/VIVA`, {
    headers: {
        "Accept": "application/json"
    }
}).then(res => res.json())
    .then(data => {
        for (let comment of data) {
            commentContainer.innerHTML += commentAsHtml(comment)
        }
    })

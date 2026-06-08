let selectedEventId = null;


async function loadEvents() {

    const response =
            await fetch(
                    "/events"
            );

    const responseData =
            await response.json();

    const events =
            responseData.data.content;

    const container =
            document.getElementById(
                    "events-container"
            );

    container.innerHTML = "";

    events.forEach(event => {

        container.innerHTML += `

        <div class="event-card">

            <h2>${event.title}</h2>

            <p>${event.description}</p>

            <p>${event.location}</p>

            <p>Capacity: ${event.capacity}</p>

            <button onclick="openModal(${event.id})">

                Register

            </button>

        </div>

        `;

    });

}

loadEvents();



function openModal(eventId){

    selectedEventId=eventId;

    document
        .getElementById(
            "registration-modal"
        )

        .classList
        .remove(
            "hidden"
        );

}



function closeModal(){

    document
        .getElementById(
            "registration-modal"
        )

        .classList
        .add(
            "hidden"
        );

}



async function submitRegistration(){

    const body={

        name:
            document
            .getElementById("name")
            .value,

        email:
            document
            .getElementById("email")
            .value,

        phone:
            document
            .getElementById("phone")
            .value,

        eventId:
            selectedEventId

    };


    const response=
        await fetch(

            "/registrations",

            {

                method:"POST",

                headers:{
                    "Content-Type":
                        "application/json"
                },

                body:
                    JSON.stringify(body)

            }

        );


    const result=
        await response.json();


    if(response.ok){

        alert(
            "Registration Successful"
        );

        closeModal();

    }

    else{

        alert(
            result.message
        );

    }

}



loadEvents();
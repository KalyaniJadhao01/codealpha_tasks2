document.addEventListener(
    "DOMContentLoaded",
    function () {

        document
            .getElementById(
                "createBtn"
            )

            .addEventListener(
                "click",
                createEvent
            );

        loadEvents();

    }
);


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

            <h3>${event.title}</h3>

            <p>${event.location}</p>

            <p>Capacity: ${event.capacity}</p>

            <button onclick="deleteEvent(${event.id})">

                Delete

            </button>

        </div>

        `;

    });

}



async function createEvent() {

    const body = {

        title:
            document
                .getElementById(
                    "title"
                ).value,

        description:
            document
                .getElementById(
                    "description"
                ).value,

        location:
            document
                .getElementById(
                    "location"
                ).value,

        eventDate:
            document
                .getElementById(
                    "date"
                ).value + ":00",

        capacity:
            parseInt(

                document
                    .getElementById(
                        "capacity"
                    ).value

            )

    };


    console.log(body);


    const response =
        await fetch(

            "/events",

            {

                method: "POST",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body:
                    JSON.stringify(
                        body
                    )

            }

        );


    if (response.ok) {

        alert(
            "Event Created"
        );

        loadEvents();

    }

    else {

        const text =
            await response.text();

        console.log(text);

        alert(
            "Creation Failed"
        );

    }

}



async function deleteEvent(id) {

    await fetch(

        "/events/" + id,

        {

            method: "DELETE"

        }

    );

    loadEvents();

}
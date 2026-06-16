// Section 1: Welcome Greeting Script Verification 
console.log("Welcome to the Community Portal");

// Application Core Architecture Runtime Memory Buffer Store
let globalEventsRegistry = [];

// Section 5: Standard OOP Constructor Schema Definition
function CommunityEvent(id, name, dateString, category, totalSeats) {
    this.id = id;
    this.name = name;
    // Section 2: Scoping Immutable Variable Declarations
    this.dateString = dateString; 
    this.eventDate = new Date(dateString);
    this.category = category;
    // Section 2: Let scope tracking variable seats allocations
    this.seatsAvailable = Number(totalSeats);
}

// Section 5: Appending Execution Prototypes Properties
CommunityEvent.prototype.checkAvailability = function() {
    const currentClockThreshold = new Date();
    // Section 3 & 5: Validate availability against seat limits and dates
    return this.seatsAvailable > 0 && this.eventDate >= currentClockThreshold;
};

// Section 4: Category registration tracking instance closure definition
function initializeCategoryRegistryTracker() {
    const internalCategoryCounters = {};
    return function(categoryName) {
        if (!internalCategoryCounters[categoryName]) {
            internalCategoryCounters[categoryName] = 0;
        }
        internalCategoryCounters[categoryName]++;
        console.log(`[Closure Diagnostic] Total registrations inside category "${categoryName}": ${internalCategoryCounters[categoryName]}`);
        return internalCategoryCounters[categoryName];
    };
}
const logCategoryRegistrationCount = initializeCategoryRegistryTracker();

// Section 9 & 12: Asynchronous Mock Endpoint Data Query Framework Simulator
async function asyncFetchRemoteEventRegistry() {
    const spinnerElement = document.getElementById("spinner");
    const containerElement = document.getElementById("eventsContainer");
    
    spinnerElement.style.display = "block";
    containerElement.innerHTML = "";

    // Simulating remote endpoint network latency 
    await new Promise(resolve => setTimeout(resolve, 1200));

    // Section 2 & 9: Standalone Raw Mock Data Input Strings Matrix Array
    const rawMockJSONStringPayload = `[
        {"id": 101, "name": "Acoustic Rock Night", "date": "2026-08-15", "category": "music", "seats": 4},
        {"id": 102, "name": "Jazz & Wine Evening", "date": "2026-09-20", "category": "music", "seats": 0},
        {"id": 103, "name": "Advanced Pastry Baking", "date": "2026-07-10", "category": "workshop", "seats": 12},
        {"id": 104, "name": "Community Paint & Sip", "date": "2026-06-30", "category": "social", "seats": 25},
        {"id": 105, "name": "Local Indie Dev Demo Meetup", "date": "2026-11-05", "category": "workshop", "seats": 8}
    ]`;

    try {
        const parsedObjects = JSON.parse(rawMockJSONStringPayload);
        globalEventsRegistry = [];
        
        // Section 6 & 10: Array push appending structured elements loop configuration map
        parsedObjects.forEach(obj => {
            const mappedEventInstance = new CommunityEvent(obj.id, obj.name, obj.date, obj.category, obj.seats);
            globalEventsRegistry.push(mappedEventInstance);
        });

        console.log("Mock database records successfully loaded and parsed into internal prototype stores.");
        spinnerElement.style.display = "none";
        
        // Render UI with current filters
        evaluateAndRenderPortalUI();
        syncFormOptionsDropdown();

    } catch (parseExceptionError) {
        console.error("Critical Exception encountered parsing payload structures:", parseExceptionError);
        spinnerElement.innerHTML = "❌ Failed to interpret remote application dataset strings.";
    }
}

// Section 4, 6, 7 & 10: Filtering array system using high order tracking and destructuring
function evaluateAndRenderPortalUI() {
    const container = document.getElementById("eventsContainer");
    const currentCategoryFilterValue = document.getElementById("categoryFilter").value;
    const currentSearchQueryValue = document.getElementById("searchInput").value.toLowerCase().trim();

    // Section 10: Clone data list via Spread operator mapping profiles patterns
    let compilationEvaluationBuffer = [...globalEventsRegistry];

    // Section 6: Specific filter application intercept for Music Events
    if (currentCategoryFilterValue === "music") {
        compilationEvaluationBuffer = compilationEvaluationBuffer.filter(evt => evt.category === "music");
    } else if (currentCategoryFilterValue !== "all") {
        compilationEvaluationBuffer = compilationEvaluationBuffer.filter(evt => evt.category === currentCategoryFilterValue);
    }

    // Dynamic text filter pass
    if (currentSearchQueryValue !== "") {
        compilationEvaluationBuffer = compilationEvaluationBuffer.filter(evt => evt.name.toLowerCase().includes(currentSearchQueryValue));
    }

    // Section 14: Use jQuery animations to cleanly crossfade UI changes
    $(container).fadeOut(150, function() {
        container.innerHTML = "";

        if (compilationEvaluationBuffer.length === 0) {
            container.innerHTML = `<div class="event-card"><p style="text-align:center; color:#64748b; margin:0;">No matching active events match criteria queries.</p></div>`;
            $(container).fadeIn(150);
            return;
        }

        // Section 3 & 6: Standard map implementation translating matching objects directly into layout templates
        const formattedHTMLCardNodesList = compilationEvaluationBuffer.map(eventInstance => {
            // Section 10: Destructuring targets from object instances
            const { id, name, dateString, category, seatsAvailable } = eventInstance;
            // Section 5: Inspect Object definitions using Object entries pipelines outputs
            console.log(`[Diagnostic Entry Log for Event ${id}]`, Object.entries(eventInstance));

            // Section 3: If-Else condition pipeline rendering blocks based on prototype criteria evaluations
            if (!eventInstance.checkAvailability()) {
                return `
                    <div class="event-card" style="opacity: 0.6; background: #f1f5f9;">
                        <div class="event-header">
                            <h3 class="event-title">${name}</h3>
                            <span class="tag" style="background:#cbd5e1;">UNAVAILABLE</span>
                        </div>
                        <p class="meta">Date: ${dateString} | Category: ${category}</p>
                        <p style="margin:0; font-weight:600; color:#94a3b8;">❌ Closed / Fully Booked</p>
                    </div>`;
            }

            // Section 2: Building element structures via Template Literals strings
            return `
                <div class="event-card" id="card-node-${id}">
                    <div class="event-header">
                        <h3 class="event-title">${name}</h3>
                        <span class="tag">${category}</span>
                    </div>
                    <p class="meta">Date: ${dateString}</p>
                    <p class="meta" id="seat-readout-${id}">Available Allocations: <strong>${seatsAvailable} seats remaining</strong></p>
                    <button type="button" class="register-btn" onclick="executeQuickRegistrationInlineAction(${id})">Quick Register Link</button>
                </div>`;
        });

        // Write array strings directly down to layout view target pipelines
        container.innerHTML = formattedHTMLCardNodesList.join("");
        $(container).fadeIn(150);
    });
}

// Keep dropdown selections synced with registry data states
function syncFormOptionsDropdown() {
    const selectMenu = document.getElementById("regEvent");
    // Clear out standard current selection indexes elements options
    selectMenu.innerHTML = `<option value="" disabled selected>Choose from available upcoming listings...</option>`;
    
    globalEventsRegistry.forEach(evt => {
        if (evt.checkAvailability()) {
            const listOptionNode = document.createElement("option");
            listOptionNode.value = evt.id;
            listOptionNode.textContent = `${evt.name} (${evt.dateString})`;
            selectMenu.appendChild(listOptionNode);
        }
    });
}

// Section 3, 4, 7 & 8: Process registrations inline using ID matching loops 
function executeQuickRegistrationInlineAction(targetEventIdentifierCode) {
    // Section 3: Core try-catch exception container pipeline block
    try {
        const structuralMatchTargetInstance = globalEventsRegistry.find(evt => evt.id === Number(targetEventIdentifierCode));
        
        if (!structuralMatchTargetInstance) {
            throw new Error("Target instance key index failed validation inside structural repository stores.");
        }

        if (!structuralMatchTargetInstance.checkAvailability()) {
            alert("This event path cannot accept additional entries.");
            return;
        }

        // Section 2: Operator decrease decrements allocations values tracking metric counters
        structuralMatchTargetInstance.seatsAvailable--;
        
        // Execute analytics counter logic inside localized closure container state instances
        logCategoryRegistrationCount(structuralMatchTargetInstance.category);

        alert(`Successfully registered for the event: "${structuralMatchTargetInstance.name}"!`);
        
        // Synchronize visual state updates across UI views
        evaluateAndRenderPortalUI();
        syncFormOptionsDropdown();

    } catch (runtimeCapturedException) {
        console.error(`[Fatal Event Registration Error Pipeline Intercept]: ${runtimeCapturedException.message}`);
        alert("Unable to process your quick registration action right now.");
    }
}

// Section 11 & 12: Handle registration submissions and mock POST data transmissions
function handleRegistrationFormSubmission(formSubmitEvent) {
    formSubmitEvent.preventDefault();

    const formElement = formSubmitEvent.target;
    // Section 11: Access fields using form elements collection matching indices
    const nameInputNode = formElement.elements["fullName"];
    const emailInputNode = formElement.elements["emailAddress"];
    const eventSelectNode = formElement.elements["selectedEvent"];

    const feedbackPane = document.getElementById("formFeedback");
    
    // Reset standard styling configurations before field validation checks
    let inputFormValidationPassed = true;
    document.querySelectorAll(".error-message").forEach(msg => msg.style.display = "none");
    document.querySelectorAll(".form-control").forEach(ctrl => ctrl.style.borderColor = "#cbd5e1");

    // Section 11: Inline Error Validation Checks
    if (!nameInputNode.value.trim()) {
        document.getElementById("nameError").style.display = "block";
        nameInputNode.style.borderColor = "#dc2626";
        inputFormValidationPassed = false;
    }
    if (!emailInputNode.value.trim() || !emailInputNode.value.includes("@")) {
        document.getElementById("emailError").style.display = "block";
        emailInputNode.style.borderColor = "#dc2626";
        inputFormValidationPassed = false;
    }
    if (!eventSelectNode.value) {
        document.getElementById("eventSelectError").style.display = "block";
        eventSelectNode.style.borderColor = "#dc2626";
        inputFormValidationPassed = false;
    }

    if (!inputFormValidationPassed) return;

    // Collate payload structure map parameters
    const coordinatedPOSTPayloadStructure = {
        registrantName: nameInputNode.value.trim(),
        registrantEmail: emailInputNode.value.trim(),
        targetEventId: Number(eventSelectNode.value)
    };

    // Section 13: Log form submission steps and check fetch request payload
    console.log("[AJAX POST Thread Initialization] Payload package compiled:", coordinatedPOSTPayloadStructure);

    feedbackPane.style.display = "block";
    feedbackPane.className = "control-field";
    feedbackPane.style.background = "#eff6ff";
    feedbackPane.style.color = "#1d4ed8";
    feedbackPane.textContent = "Processing secure network pipeline connection payloads...";

    // Section 12: Simulating backend communication with fetch and a delayed response via setTimeout
    setTimeout(() => {
        // Section 12: Executing structured POST pipeline connections maps
        fetch("https://jsonplaceholder.typicode.com/posts", {
            method: "POST",
            body: JSON.stringify(coordinatedPOSTPayloadStructure),
            headers: { "Content-type": "application/json; charset=UTF-8" }
        })
        .then(networkStreamResultResponse => {
            if (!networkStreamResultResponse.ok) {
                throw new Error("Remote server node returned an invalid operational status signature flag.");
            }
            return networkStreamResultResponse.json();
        })
        .then(parsedSuccessDataResultObject => {
            console.log("[AJAX Communication Chain - Success Verification Pack]", parsedSuccessDataResultObject);
            
            // Apply corresponding decrement action logic metrics to local runtime instances parameters
            const matchedTargetInstance = globalEventsRegistry.find(evt => evt.id === coordinatedPOSTPayloadStructure.targetEventId);
            if (matchedTargetInstance) {
                matchedTargetInstance.seatsAvailable--;
                logCategoryRegistrationCount(matchedTargetInstance.category);
            }

            feedbackPane.className = "control-field success-alert";
            feedbackPane.innerHTML = `<strong>Registration Approved!</strong> Your digital receipt token ID is: <code>SERVER-ID-${parsedSuccessDataResultObject.id}</code>. Your verification space entry is confirmed.`;
            
            formElement.reset();
            evaluateAndRenderPortalUI();
            syncFormOptionsDropdown();
        })
        .catch(networkCommunicationExecutionException => {
            console.error("[AJAX Pipeline Request Failure]:", networkCommunicationExecutionException);
            feedbackPane.className = "control-field failure-alert";
            feedbackPane.textContent = "Critical operational pipeline error: Remote server rejected data transport handshakes.";
        });
    }, 1000);
}

// Section 1 & 8: Attach application execution startup lifecycle hooks
window.addEventListener("load", () => {
    // Section 1: Launch alert verification window notification parameters hooks
    alert("Local Community Event Portal Interface Assets Loaded Successfully!");
    
    // Prime internal arrays structures via core loader modules execution pipelines
    asyncFetchRemoteEventRegistry();

    // Section 8: Attach change handler listeners to category filtering selectors
    document.getElementById("categoryFilter").addEventListener("change", (changeEvent) => {
        // Section 8 & 10: Persist user selection filter category choices directly down to localStorage
        localStorage.setItem("portalPreferredCategory", changeEvent.target.value);
        evaluateAndRenderPortalUI();
    });

    // Section 8: Keydown search lookup filter event observer attachments rules
    document.getElementById("searchInput").addEventListener("keydown", () => {
        // Use minimal debounce delay scheduling updates to interface views configurations
        setTimeout(evaluateAndRenderPortalUI, 50);
    });

    // Section 8: Form Submission Event Handler Binding pipeline rules
    document.getElementById("registrationForm").addEventListener("submit", handleRegistrationFormSubmission);

    // Section 8: Clear preferences runtime listener registration routine actions
    document.getElementById("clearPrefsBtn").addEventListener("click", () => {
        localStorage.removeItem("portalPreferredCategory");
        document.getElementById("categoryFilter").value = "all";
        evaluateAndRenderPortalUI();
        console.log("Cleared portal filter configuration preferences from local storage caches.");
    });

    // Read and parse historical context parameters values from localStorage configurations pools
    const historicalCategoryPreferenceStringValue = localStorage.getItem("portalPreferredCategory");
    if (historicalCategoryPreferenceStringValue) {
        document.getElementById("categoryFilter").value = historicalCategoryPreferenceStringValue;
        console.log(`Restored category preference filter choice state configuration from cache: ${historicalCategoryPreferenceStringValue}`);
    }
});
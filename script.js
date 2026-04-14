// ===== STUDENT DATA STORAGE =====
let currentStudent = null;

// ===== ELECTIVES DATABASE =====
const electivesData = [
    {
        id: 1,
        name: "Web Development Fundamentals",
        code: "CS401",
        branch: "CS",
        description: "Learn HTML, CSS, JavaScript and build responsive web applications.",
        faculty: "Dr. Rajesh Sharma",
        semester: "4",
        credits: 3,
        prerequisites: "Basic Programming",
        practicalBased: true,
        difficulty: "Intermediate",
        timing: "Morning",
        rating: 4.5,
        reviews: [
            { student: "Amit Patel", rating: 5, text: "Amazing course! Very practical and hands-on." },
            { student: "Priya Kumar", rating: 4, text: "Good content but could use more real-world projects." }
        ]
    },
    {
        id: 2,
        name: "Data Science with Python",
        code: "CS402",
        branch: "CS",
        description: "Master data analysis, visualization, and machine learning basics with Python.",
        faculty: "Prof. Neha Gupta",
        semester: "4",
        credits: 3,
        prerequisites: "Mathematics, Python Basics",
        practicalBased: true,
        difficulty: "Advanced",
        timing: "Afternoon",
        rating: 4.7,
        reviews: [
            { student: "Ravi Singh", rating: 5, text: "Best course ever! Prof. Gupta is excellent." },
            { student: "Zara Ahmed", rating: 5, text: "Comprehensive curriculum with great projects." }
        ]
    },
    {
        id: 3,
        name: "Database Systems & SQL",
        code: "CS403",
        branch: "CS",
        description: "Design and manage databases, write complex SQL queries, normalize schemas.",
        faculty: "Dr. Vikram Desai",
        semester: "4",
        credits: 3,
        prerequisites: "Data Structures",
        practicalBased: true,
        difficulty: "Intermediate",
        timing: "Evening",
        rating: 4.3,
        reviews: [
            { student: "Harsh Verma", rating: 4, text: "Solid course with good lab work." },
            { student: "Ananya Iyer", rating: 4, text: "Content is dense but well-structured." }
        ]
    },
    {
        id: 4,
        name: "Cybersecurity Essentials",
        code: "IT404",
        branch: "IT",
        description: "Understand security principles, encryption, network security, and ethical hacking.",
        faculty: "Mr. Sanjay Chopra",
        semester: "4",
        credits: 3,
        prerequisites: "Networking Basics",
        practicalBased: true,
        difficulty: "Advanced",
        timing: "Morning",
        rating: 4.6,
        reviews: [
            { student: "Karan Malhotra", rating: 5, text: "Highly relevant in today's world." },
            { student: "Sneha Das", rating: 4, text: "Practical labs are excellent." }
        ]
    },
    {
        id: 5,
        name: "Cloud Computing with AWS",
        code: "IT405",
        branch: "IT",
        description: "Deploy and manage applications on AWS. Learn EC2, S3, Lambda, and more.",
        faculty: "Dr. Arjun Patel",
        semester: "4",
        credits: 3,
        prerequisites: "Basic Systems Knowledge",
        practicalBased: true,
        difficulty: "Intermediate",
        timing: "Afternoon",
        rating: 4.4,
        reviews: [
            { student: "Vishal Kumar", rating: 4, text: "Good introduction to cloud platforms." },
            { student: "Meera Reddy", rating: 5, text: "Hands-on labs are very practical." }
        ]
    },
    {
        id: 6,
        name: "Artificial Intelligence & Machine Learning",
        code: "CS406",
        branch: "CS",
        description: "Deep dive into AI concepts, neural networks, supervised and unsupervised learning.",
        faculty: "Dr. Priya Sharma",
        semester: "4",
        credits: 4,
        prerequisites: "Mathematics, Python, Data Science Basics",
        practicalBased: true,
        difficulty: "Advanced",
        timing: "Morning",
        rating: 4.8,
        reviews: [
            { student: "Arjun Singh", rating: 5, text: "Most comprehensive AI course on campus." },
            { student: "Deepa Nair", rating: 5, text: "Dr. Sharma explains complex concepts beautifully." }
        ]
    },
    {
        id: 7,
        name: "Mobile App Development",
        code: "IT406",
        branch: "IT",
        description: "Build iOS and Android applications using modern frameworks and best practices.",
        faculty: "Ms. Divya Kapoor",
        semester: "4",
        credits: 3,
        prerequisites: "Object-Oriented Programming",
        practicalBased: true,
        difficulty: "Intermediate",
        timing: "Afternoon",
        rating: 4.5,
        reviews: [
            { student: "Nikhil Sharma", rating: 5, text: "Great for aspiring app developers." },
            { student: "Isha Pandey", rating: 4, text: "Fast-paced but very rewarding." }
        ]
    },
    {
        id: 8,
        name: "Embedded Systems Programming",
        code: "EC407",
        branch: "EC",
        description: "Program microcontrollers, IoT devices, and understand hardware interfacing.",
        faculty: "Dr. Arun Verma",
        semester: "4",
        credits: 3,
        prerequisites: "C Programming, Digital Logic",
        practicalBased: true,
        difficulty: "Advanced",
        timing: "Evening",
        rating: 4.4,
        reviews: [
            { student: "Rohan Deshmukh", rating: 4, text: "Perfect for hardware enthusiasts." },
            { student: "Sonal Jain", rating: 5, text: "Lab work is challenging and fun." }
        ]
    },
    {
        id: 9,
        name: "Software Engineering & Project Management",
        code: "CS408",
        branch: "CS",
        description: "Learn SDLC, Agile methodologies, design patterns, and project management.",
        faculty: "Prof. Ashok Kumar",
        semester: "4",
        credits: 3,
        prerequisites: "Programming Fundamentals",
        practicalBased: false,
        difficulty: "Intermediate",
        timing: "Morning",
        rating: 4.2,
        reviews: [
            { student: "Vikram Reddy", rating: 4, text: "Excellent for understanding real-world development." },
            { student: "Pooja Sharma", rating: 4, text: "Great group projects." }
        ]
    },
    {
        id: 10,
        name: "Advanced Algorithms & Competitive Programming",
        code: "CS409",
        branch: "CS",
        description: "Master algorithmic problem-solving, competitive coding, and optimization.",
        faculty: "Dr. Suresh Patil",
        semester: "4",
        credits: 3,
        prerequisites: "Data Structures, Mathematics",
        practicalBased: true,
        difficulty: "Advanced",
        timing: "Evening",
        rating: 4.6,
        reviews: [
            { student: "Rahul Verma", rating: 5, text: "Perfect for placement preparation." },
            { student: "Anjali Singh", rating: 5, text: "Prof. Patil is an excellent mentor." }
        ]
    }
];

// ===== SECTION MANAGEMENT =====
function showSection(sectionId) {
    // Hide all sections
    const sections = document.querySelectorAll('.section');
    sections.forEach(section => section.classList.remove('active'));
    
    // Show selected section
    const selectedSection = document.getElementById(sectionId);
    if (selectedSection) {
        selectedSection.classList.add('active');
        
        // Load electives if explore section
        if (sectionId === 'explore') {
            loadElectives();
        }
    }
    
    // Scroll to top
    window.scrollTo(0, 0);
}

// ===== LOGIN FUNCTIONALITY =====
function loginStudent() {
    const name = document.getElementById('name').value.trim();
    const rollNumber = document.getElementById('rollNumber').value.trim();
    const branch = document.getElementById('branch').value;
    const year = document.getElementById('year').value;

    if (!name || !rollNumber || !branch || !year) {
        alert('Please fill in all fields');
        return;
    }

    currentStudent = {
        name: name,
        rollNumber: rollNumber,
        branch: branch,
        year: year,
        quizAnswers: null
    };

    // Reset form
    document.getElementById('loginForm').reset();
    
    // Show quiz section
    showSection('quiz');
}

// ===== QUIZ SUBMISSION =====
function submitQuiz() {
    const quizForm = document.getElementById('quizForm');
    const answers = {
        careerAmbition: document.querySelector('input[name="careerAmbition"]:checked')?.value || null,
        techInterest: document.querySelector('input[name="techInterest"]:checked')?.value || null,
        codingExperience: document.querySelector('input[name="codingExperience"]:checked')?.value || null,
        availableTime: document.querySelector('input[name="availableTime"]:checked')?.value || null,
        learningStyle: document.querySelector('input[name="learningStyle"]:checked')?.value || null,
        orientation: document.querySelector('input[name="orientation"]:checked')?.value || null,
        classTime: document.querySelector('input[name="classTime"]:checked')?.value || null,
        teamPreference: document.querySelector('input[name="teamPreference"]:checked')?.value || null
    };

    // Validate all answers are selected
    for (let key in answers) {
        if (answers[key] === null) {
            alert('Please answer all questions before submitting');
            return;
        }
    }

    currentStudent.quizAnswers = answers;
    
    // Get recommendations based on answers
    const recommendations = getRecommendations(answers);
    
    // Display results
    displayResults(recommendations);
    showSection('results');
}

// ===== RECOMMENDATION ENGINE =====
function getRecommendations(answers) {
    const scores = {};
    
    // Initialize scores for all electives
    electivesData.forEach(elective => {
        scores[elective.id] = { score: 0, reasons: [] };
    });

    // Scoring logic based on answers
    
    // 1. Career Ambition Matching
    if (answers.careerAmbition === "Software Development") {
        scores[1].score += 20;
        scores[1].reasons.push("Web dev aligns with your software development goals");
        scores[3].score += 10;
        scores[9].score += 15;
    } else if (answers.careerAmbition === "Data Science") {
        scores[2].score += 25;
        scores[2].reasons.push("Perfect match for your data science aspirations");
        scores[6].score += 20;
        scores[6].reasons.push("AI/ML is crucial for data science career");
    } else if (answers.careerAmbition === "System Design") {
        scores[3].score += 20;
        scores[5].score += 18;
        scores[9].score += 15;
    } else if (answers.careerAmbition === "Cybersecurity") {
        scores[4].score += 25;
        scores[4].reasons.push("Directly relevant to cybersecurity career");
        scores[3].score += 10;
    } else if (answers.careerAmbition === "Hardware") {
        scores[8].score += 25;
        scores[8].reasons.push("Perfect for embedded systems and hardware work");
    }

    // 2. Technical Interest Matching
    if (answers.techInterest === "Frontend") {
        scores[1].score += 15;
        scores[1].reasons.push("Web dev covers frontend technologies well");
        scores[7].score += 15;
    } else if (answers.techInterest === "Backend") {
        scores[3].score += 15;
        scores[5].score += 15;
        scores[3].reasons.push("Database systems essential for backend development");
    } else if (answers.techInterest === "Mathematical") {
        scores[10].score += 20;
        scores[10].reasons.push("Algorithms course uses heavy mathematical concepts");
        scores[6].score += 15;
    } else if (answers.techInterest === "Systems") {
        scores[3].score += 10;
        scores[8].score += 20;
    } else if (answers.techInterest === "IoT") {
        scores[8].score += 25;
        scores[5].score += 10;
    }

    // 3. Coding Experience
    if (answers.codingExperience === "Beginner") {
        scores[1].score += 10;
        scores[1].reasons.push("Web dev is beginner-friendly");
        scores[5].score += 8;
    } else if (answers.codingExperience === "Intermediate") {
        scores[3].score += 10;
        scores[2].score += 10;
    } else if (answers.codingExperience === "Advanced") {
        scores[6].score += 15;
        scores[10].score += 15;
    }

    // 4. Available Time
    if (answers.availableTime === "Limited") {
        scores[9].score += 15;
        scores[9].reasons.push("Less practical work, suitable for limited time");
    } else if (answers.availableTime === "Extensive") {
        scores[6].score += 15;
        scores[8].score += 10;
    }

    // 5. Learning Style
    if (answers.learningStyle === "Hands-on") {
        scores[1].score += 15;
        scores[7].score += 15;
        scores[8].score += 15;
    } else if (answers.learningStyle === "Theoretical") {
        scores[9].score += 15;
        scores[10].score += 15;
    }

    // 6. Orientation (Practical vs Research)
    if (answers.orientation === "Practical") {
        scores[1].score += 10;
        scores[5].score += 12;
        scores[7].score += 10;
    } else if (answers.orientation === "Research") {
        scores[6].score += 15;
        scores[10].score += 12;
    }

    // 7. Class Timing
    if (answers.classTime === "Morning") {
        scores[1].score += 5;
        scores[4].score += 5;
        scores[6].score += 5;
    } else if (answers.classTime === "Afternoon") {
        scores[2].score += 5;
        scores[5].score += 5;
        scores[7].score += 5;
    } else if (answers.classTime === "Evening") {
        scores[3].score += 5;
        scores[8].score += 5;
        scores[10].score += 5;
    }

    // 8. Team Preference
    if (answers.teamPreference === "Team") {
        scores[2].score += 10;
        scores[7].score += 10;
    }

    // Create ranking
    const ranking = Object.entries(scores).map(([id, data]) => ({
        id: parseInt(id),
        ...data,
        elective: electivesData.find(e => e.id === parseInt(id))
    }));

    // Sort by score descending
    ranking.sort((a, b) => b.score - a.score);

    // Categorize into tiers
    const result = {
        tier1: ranking.slice(0, 3),
        tier2: ranking.slice(3, 6),
        tier3: ranking.slice(6, 10)
    };

    return result;
}

// ===== DISPLAY RESULTS =====
function displayResults(recommendations) {
    // Display student info
    const studentInfoDiv = document.getElementById('studentInfo');
    studentInfoDiv.innerHTML = `
        <h3>Welcome, ${currentStudent.name}</h3>
        <p><strong>Roll Number:</strong> ${currentStudent.rollNumber} | 
           <strong>Branch:</strong> ${currentStudent.branch} | 
           <strong>Year:</strong> Year ${currentStudent.year}</p>
    `;

    // Display recommendations
    const container = document.getElementById('recommendedElectives');
    let html = '';

    // Tier 1 - Highly Recommended
    html += '<h3 style="margin-top: 2rem; color: #22c55e;">🎯 Tier 1: Highly Recommended</h3>';
    html += '<p style="color: #666; margin-bottom: 1rem;">These electives are the best match for your profile.</p>';
    html += '<div class="tier-cards">';
    recommendations.tier1.forEach(rec => {
        html += createRecommendationCard(rec, 'tier-1');
    });
    html += '</div>';

    // Tier 2 - Also Good
    html += '<h3 style="margin-top: 2rem; color: #f59e0b;">⭐ Tier 2: Also Good Options</h3>';
    html += '<p style="color: #666; margin-bottom: 1rem;">These are solid choices that align well with your interests.</p>';
    html += '<div class="tier-cards">';
    recommendations.tier2.forEach(rec => {
        html += createRecommendationCard(rec, 'tier-2');
    });
    html += '</div>';

    // Tier 3 - Consider These
    html += '<h3 style="margin-top: 2rem; color: #ef4444;">💡 Tier 3: Consider These</h3>';
    html += '<p style="color: #666; margin-bottom: 1rem;">Good options if you want to explore new areas.</p>';
    html += '<div class="tier-cards">';
    recommendations.tier3.forEach(rec => {
        html += createRecommendationCard(rec, 'tier-3');
    });
    html += '</div>';

    container.innerHTML = html;
}

function createRecommendationCard(rec, tierClass) {
    const tierLabel = tierClass === 'tier-1' ? 'Highly Recommended' : 
                      tierClass === 'tier-2' ? 'Good Option' : 'Consider';
    
    return `
        <div class="recommendation-card ${tierClass}">
            <span class="tier-label">${tierLabel}</span>
            <h3>${rec.elective.name}</h3>
            <p><strong>Code:</strong> ${rec.elective.code}</p>
            <p><strong>Faculty:</strong> ${rec.elective.faculty}</p>
            <p><strong>Rating:</strong> ⭐ ${rec.elective.rating}/5.0</p>
            <div class="reasoning">
                <strong>Why this?</strong> ${rec.reasons.length > 0 ? rec.reasons[0] : 'Matches your profile well'}
            </div>
            <button class="btn btn-primary" style="margin-top: 1rem; width: 100%;" 
                    onclick="viewElectiveDetail(${rec.id})">View Details</button>
        </div>
    `;
}

// ===== LOAD ELECTIVES =====
function loadElectives() {
    const container = document.getElementById('electivesContainer');
    let html = '';

    electivesData.forEach(elective => {
        html += `
            <div class="elective-card" onclick="viewElectiveDetail(${elective.id})">
                <div class="elective-header">
                    <h3>${elective.name}</h3>
                    <span class="elective-branch">${elective.code} • ${elective.branch}</span>
                </div>
                <div class="elective-body">
                    <p>${elective.description}</p>
                    <p class="faculty-name">👨‍🏫 ${elective.faculty}</p>
                    <p class="rating">⭐ ${elective.rating}/5.0</p>
                </div>
            </div>
        `;
    });

    container.innerHTML = html;
}

// ===== FILTER ELECTIVES =====
function filterElectives() {
    const searchTerm = document.getElementById('searchElective').value.toLowerCase();
    const branchFilter = document.getElementById('filterBranch').value;

    const filtered = electivesData.filter(elective => {
        const matchesSearch = elective.name.toLowerCase().includes(searchTerm) || 
                            elective.code.toLowerCase().includes(searchTerm);
        const matchesBranch = branchFilter === '' || elective.branch === branchFilter;
        return matchesSearch && matchesBranch;
    });

    const container = document.getElementById('electivesContainer');
    let html = '';

    if (filtered.length === 0) {
        html = '<p style="grid-column: 1/-1; text-align: center; color: #666;">No electives found.</p>';
    } else {
        filtered.forEach(elective => {
            html += `
                <div class="elective-card" onclick="viewElectiveDetail(${elective.id})">
                    <div class="elective-header">
                        <h3>${elective.name}</h3>
                        <span class="elective-branch">${elective.code} • ${elective.branch}</span>
                    </div>
                    <div class="elective-body">
                        <p>${elective.description}</p>
                        <p class="faculty-name">👨‍🏫 ${elective.faculty}</p>
                        <p class="rating">⭐ ${elective.rating}/5.0</p>
                    </div>
                </div>
            `;
        });
    }

    container.innerHTML = html;
}

// ===== VIEW ELECTIVE DETAIL =====
function viewElectiveDetail(electiveId) {
    const elective = electivesData.find(e => e.id === electiveId);
    if (!elective) return;

    const detailContent = document.getElementById('electiveDetailContent');
    let reviewsHtml = '';

    elective.reviews.forEach(review => {
        reviewsHtml += `
            <div class="review-item">
                <div class="review-student">${review.student}</div>
                <div class="review-rating">Rating: ${'⭐'.repeat(review.rating)} (${review.rating}/5)</div>
                <div class="review-text">"${review.text}"</div>
            </div>
        `;
    });

    detailContent.innerHTML = `
        <h2>${elective.name}</h2>
        
        <div class="detail-section">
            <h3>Course Information</h3>
            <p><strong>Code:</strong> ${elective.code}</p>
            <p><strong>Branch:</strong> ${elective.branch}</p>
            <p><strong>Semester:</strong> ${elective.semester}</p>
            <p><strong>Credits:</strong> ${elective.credits}</p>
            <p><strong>Difficulty Level:</strong> ${elective.difficulty}</p>
            <p><strong>Class Timing:</strong> ${elective.classTime}</p>
            <p><strong>Prerequisites:</strong> ${elective.prerequisites}</p>
        </div>

        <div class="detail-section">
            <h3>Course Description</h3>
            <p>${elective.description}</p>
        </div>

        <div class="detail-section">
            <h3>Faculty Information</h3>
            <p><strong>Instructor:</strong> ${elective.faculty}</p>
            <p><strong>Course Rating:</strong> ⭐ ${elective.rating}/5.0</p>
            <p><strong>Course Type:</strong> ${elective.practicalBased ? 'Practical-based' : 'Theory-based'}</p>
        </div>

        <div class="detail-section">
            <h3>Student Reviews</h3>
            <div class="reviews-container">
                ${reviewsHtml}
            </div>
        </div>

        <div class="button-group">
            <button class="btn btn-primary">Select This Elective</button>
            <button class="btn btn-secondary" onclick="showSection('explore')">Back to Electives</button>
        </div>
    `;

    showSection('electiveDetail');
}

// ===== INITIALIZE ON PAGE LOAD =====
document.addEventListener('DOMContentLoaded', function() {
    showSection('home');
});

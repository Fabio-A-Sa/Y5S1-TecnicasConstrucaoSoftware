/**
 */
package tutorial.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.ocl.pivot.evaluation.Executor;

import org.eclipse.ocl.pivot.ids.IdResolver;

import org.eclipse.ocl.pivot.ids.IdResolver.IdResolverExtension;

import org.eclipse.ocl.pivot.ids.TypeId;

import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;

import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;

import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;

import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;

import org.eclipse.ocl.pivot.values.SetValue.Accumulator;

import tutorial.Book;
import tutorial.Library;
import tutorial.Loan;
import tutorial.Member;
import tutorial.TutorialPackage;
import tutorial.TutorialTables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tutorial.impl.MemberImpl#getName <em>Name</em>}</li>
 *   <li>{@link tutorial.impl.MemberImpl#getLibrary <em>Library</em>}</li>
 *   <li>{@link tutorial.impl.MemberImpl#getLoans <em>Loans</em>}</li>
 *   <li>{@link tutorial.impl.MemberImpl#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemberImpl extends MinimalEObjectImpl.Container implements Member {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TutorialPackage.Literals.MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TutorialPackage.MEMBER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Library getLibrary() {
		if (eContainerFeatureID() != TutorialPackage.MEMBER__LIBRARY) return null;
		return (Library)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLibrary(Library newLibrary, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLibrary, TutorialPackage.MEMBER__LIBRARY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLibrary(Library newLibrary) {
		if (newLibrary != eInternalContainer() || (eContainerFeatureID() != TutorialPackage.MEMBER__LIBRARY && newLibrary != null)) {
			if (EcoreUtil.isAncestor(this, newLibrary))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLibrary != null)
				msgs = ((InternalEObject)newLibrary).eInverseAdd(this, TutorialPackage.LIBRARY__MEMBERS, Library.class, msgs);
			msgs = basicSetLibrary(newLibrary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TutorialPackage.MEMBER__LIBRARY, newLibrary, newLibrary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Loan> getLoans() {
		/**
		 * library.loans->select(member = self)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ Library library = this.getLibrary();
		if (library == null) {
			throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/mdt/ocl/oclinecore/tutorial\'::Library::loans\'");
		}
		final /*@Thrown*/ List<Loan> loans = library.getLoans();
		final /*@Thrown*/ SetValue BOXED_loans = idResolver.createSetOfAll(TutorialTables.SET_CLSSid_Loan, loans);
		/*@Thrown*/ Accumulator accumulator = ValueUtil.createSetAccumulatorValue(TutorialTables.SET_CLSSid_Loan);
		Iterator<Object> ITERATOR__1 = BOXED_loans.iterator();
		/*@Thrown*/ SetValue select;
		while (true) {
			if (!ITERATOR__1.hasNext()) {
				select = accumulator;
				break;
			}
			/*@NonInvalid*/ Loan _1 = (Loan)ITERATOR__1.next();
			/**
			 * member = self
			 */
			if (_1 == null) {
				throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/mdt/ocl/oclinecore/tutorial\'::Loan::member\'");
			}
			final /*@Thrown*/ Member member = _1.getMember();
			final /*@Thrown*/ boolean eq = member.equals(this);
			//
			if (eq == ValueUtil.TRUE_VALUE) {
				accumulator.add(_1);
			}
		}
		final /*@Thrown*/ List<Loan> ECORE_select = ((IdResolverExtension)idResolver).ecoreValueOfAll(Loan.class, select);
		return (EList<Loan>)ECORE_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Book> getBooks() {
		/**
		 * loans->collect(book)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ List<Loan> loans = this.getLoans();
		final /*@NonInvalid*/ SetValue BOXED_loans = idResolver.createSetOfAll(TutorialTables.SET_CLSSid_Loan, loans);
		/*@Thrown*/ org.eclipse.ocl.pivot.values.BagValue.Accumulator accumulator = ValueUtil.createBagAccumulatorValue(TutorialTables.BAG_CLSSid_Book_0);
		Iterator<Object> ITERATOR__1 = BOXED_loans.iterator();
		/*@Thrown*/ BagValue collect;
		while (true) {
			if (!ITERATOR__1.hasNext()) {
				collect = accumulator;
				break;
			}
			/*@NonInvalid*/ Loan _1 = (Loan)ITERATOR__1.next();
			/**
			 * book
			 */
			if (_1 == null) {
				throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/mdt/ocl/oclinecore/tutorial\'::Loan::book\'");
			}
			final /*@Thrown*/ Book book = _1.getBook();
			//
			accumulator.add(book);
		}
		final /*@Thrown*/ List<Book> ECORE_collect = ((IdResolverExtension)idResolver).ecoreValueOfAll(Book.class, collect);
		return (EList<Book>)ECORE_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean AtMostTwoLoans(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final String constraintName = "Member::AtMostTwoLoans";
		try {
			/**
			 *
			 * inv AtMostTwoLoans:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = loans->size() <= 2
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, TutorialPackage.Literals.MEMBER___AT_MOST_TWO_LOANS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, TutorialTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ List<Loan> loans = this.getLoans();
				final /*@NonInvalid*/ SetValue BOXED_loans = idResolver.createSetOfAll(TutorialTables.SET_CLSSid_Loan, loans);
				final /*@NonInvalid*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_loans);
				final /*@NonInvalid*/ boolean result = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, size, TutorialTables.INT_2).booleanValue();
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, TutorialTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean UniqueLoans(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final String constraintName = "Member::UniqueLoans";
		try {
			/**
			 *
			 * inv UniqueLoans:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = loans->isUnique(book)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, TutorialPackage.Literals.MEMBER___UNIQUE_LOANS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, TutorialTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ List<Loan> loans = this.getLoans();
					final /*@NonInvalid*/ SetValue BOXED_loans = idResolver.createSetOfAll(TutorialTables.SET_CLSSid_Loan, loans);
					/*@Thrown*/ Accumulator accumulator = ValueUtil.createSetAccumulatorValue(TutorialTables.SET_CLSSid_Loan);
					Iterator<Object> ITERATOR__1 = BOXED_loans.iterator();
					/*@Thrown*/ boolean result;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							result = true;
							break;
						}
						/*@NonInvalid*/ Loan _1 = (Loan)ITERATOR__1.next();
						/**
						 * book
						 */
						if (_1 == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/mdt/ocl/oclinecore/tutorial\'::Loan::book\'");
						}
						final /*@Thrown*/ Book book = _1.getBook();
						//
						if (accumulator.includes(book) == ValueUtil.TRUE_VALUE) {
							result = false;
							break;			// Abort after second find
						}
						else {
							accumulator.add(book);
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, TutorialTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TutorialPackage.MEMBER__LIBRARY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLibrary((Library)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TutorialPackage.MEMBER__LIBRARY:
				return basicSetLibrary(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TutorialPackage.MEMBER__LIBRARY:
				return eInternalContainer().eInverseRemove(this, TutorialPackage.LIBRARY__MEMBERS, Library.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TutorialPackage.MEMBER__NAME:
				return getName();
			case TutorialPackage.MEMBER__LIBRARY:
				return getLibrary();
			case TutorialPackage.MEMBER__LOANS:
				return getLoans();
			case TutorialPackage.MEMBER__BOOKS:
				return getBooks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TutorialPackage.MEMBER__NAME:
				setName((String)newValue);
				return;
			case TutorialPackage.MEMBER__LIBRARY:
				setLibrary((Library)newValue);
				return;
			case TutorialPackage.MEMBER__LOANS:
				getLoans().clear();
				getLoans().addAll((Collection<? extends Loan>)newValue);
				return;
			case TutorialPackage.MEMBER__BOOKS:
				getBooks().clear();
				getBooks().addAll((Collection<? extends Book>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TutorialPackage.MEMBER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TutorialPackage.MEMBER__LIBRARY:
				setLibrary((Library)null);
				return;
			case TutorialPackage.MEMBER__LOANS:
				getLoans().clear();
				return;
			case TutorialPackage.MEMBER__BOOKS:
				getBooks().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TutorialPackage.MEMBER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TutorialPackage.MEMBER__LIBRARY:
				return getLibrary() != null;
			case TutorialPackage.MEMBER__LOANS:
				return !getLoans().isEmpty();
			case TutorialPackage.MEMBER__BOOKS:
				return !getBooks().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TutorialPackage.MEMBER___AT_MOST_TWO_LOANS__DIAGNOSTICCHAIN_MAP:
				return AtMostTwoLoans((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case TutorialPackage.MEMBER___UNIQUE_LOANS__DIAGNOSTICCHAIN_MAP:
				return UniqueLoans((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MemberImpl
